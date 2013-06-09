package no.jaf.pomalyzer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import no.jaf.pomalyzer.domain.PomFile;
import no.jaf.pomalyzer.domain.Project;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class POMReader {
    
    public static List<PomFile> findPoms(int depth, File file) throws IOException {

        List<PomFile> pomFiles = new ArrayList<>();

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                for(PomFile pomFile :findPoms(depth + 4, files[i])){
                    pomFiles.add(pomFile);
                }
            }
        } else {
            if ("pom.xml".equals(file.getName())) {
                pomFiles.add(new PomFile(file.getParent() + "\\" + file.getName(), file.length()));
            }
        }
        return pomFiles;
    }
    
    public static Project readXml(File file) {
        try {

            File stocks = file;
            System.out.println("Filename: " + file.getPath());
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(stocks);
            doc.getDocumentElement().normalize();

            return extractProject(doc.getDocumentElement());
            //System.out.println("==========================");
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    private static Project extractProject(Element root) {
        NodeList rootChilds = root.getChildNodes();

        Project project = new Project();
        for (int i = 0; i < rootChilds.getLength(); i++) {
            if (1 == rootChilds.item(i).getNodeType()) {
                Node nodeForAnalyzis = rootChilds.item(i);
                if("modelVersion".equals(nodeForAnalyzis.getNodeName())){
                   project.setModelVersion(nodeForAnalyzis.getChildNodes().item(0).getNodeValue());
                }else if("groupId".equals(nodeForAnalyzis.getNodeName())){
                   project.setGroupId(nodeForAnalyzis.getChildNodes().item(0).getNodeValue());
                }else if("artifactId".equals(nodeForAnalyzis.getNodeName())){
                   project.setArtifactId(nodeForAnalyzis.getChildNodes().item(0).getNodeValue());
                }else if("packaging".equals(nodeForAnalyzis.getNodeName())){
                   project.setPackaging(nodeForAnalyzis.getChildNodes().item(0).getNodeValue());
                }else if("version".equals(nodeForAnalyzis.getNodeName())){
                   project.setVersion(nodeForAnalyzis.getChildNodes().item(0).getNodeValue());
                }
            }
        }
        return project;
    }
}
