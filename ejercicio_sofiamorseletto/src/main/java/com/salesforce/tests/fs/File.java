package com.salesforce.tests.fs;

import java.util.HashSet;
import java.util.Set;

public class File implements Component{

    private String path;
    private Component parent;

    public File(String path, Component parent){
        this.path = path;
        this.parent = parent;
    }

    public Boolean addDirectory(String name) {
        return null;
    }

    public Component goToChild(String name) {
        return null;
    }

    public Component goToParent() {
        return null;
    }

    public Set<String> getChildrenNames() {
        return new HashSet<String>();
    }

    public String getPath() {
        return path;
    }

    public void addFile(String name) {

    }
}
