/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package no.jaf.pomalyzer.domain;

/**
 *
 * @author Jon
 */
public class Dependency {
    
    private String artifactId;
    private String groupId;
    private String version;
    private String scope;

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
    
    
    
}
