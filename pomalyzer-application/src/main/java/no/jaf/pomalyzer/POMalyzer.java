package no.jaf.pomalyzer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import no.jaf.pomalyzer.domain.PomFile;
import no.jaf.pomalyzer.domain.Project;

public class POMalyzer {

    public static void main(String[] args) {

        List<Project> projects = new ArrayList<>();
        
        try {
            System.out.println("--> Scanning directories for pom.xml");
            List<PomFile> pomFiles = POMReader.findPoms(0, new File("C:\\Data\\git\\"));
            System.out.println("--> Directories scanned");

            if (pomFiles.isEmpty()) {
                System.out.println("--> No pom.xml files found");
            } else {
                System.out.println("--> Number of pom.xml files found: " + pomFiles.size());
                
                for (PomFile pom : pomFiles) {
                    //System.out.println(pom.getPath() + " (" + pom.getLength() + " bytes)");
                    projects.add(POMReader.readXml(new File(pom.getPath())));
                }                
            }
            System.out.println(projects);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
