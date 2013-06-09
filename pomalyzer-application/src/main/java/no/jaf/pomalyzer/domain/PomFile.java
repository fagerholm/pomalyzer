package no.jaf.pomalyzer.domain;

public class PomFile {

    private String path;
    private long length;
    
    public PomFile(String path, long length){
        this.path = path;
        this.length = length;
    }

    public String getPath() {
        return path;
    }

    public long getLength() {
        return length;
    }
    
}
