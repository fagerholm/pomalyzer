/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package no.jaf.pomalyzer.domain;

import java.util.List;

/**
 *
 * @author Jon
 */
public class Project {
    
    private String modelVersion;
    private String groupId;
    private String artifactId;
    private String packaging;
    private String version;
    private List<Dependency> dependencies;
    private Dependency parent;

    public String getModelVersion() {
        return modelVersion;
    }

    public void setModelVersion(String modelVersion) {
        this.modelVersion = modelVersion;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<Dependency> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<Dependency> dependencies) {
        this.dependencies = dependencies;
    }

    public Dependency getParent() {
        return parent;
    }

    public void setParent(Dependency parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Project{" + "modelVersion=" + modelVersion + ", groupId=" + groupId + ", artifactId=" + artifactId + ", packaging=" + packaging + ", version=" + version + ", dependencies=" + dependencies + ", parent=" + parent + '}';
    }
    
    
}