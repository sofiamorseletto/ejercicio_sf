package com.salesforce.tests.fs;

import java.util.HashMap;
import java.util.Set;

public class Directory implements Component{

    private String path;
    private Component parent;
    private HashMap<String, Component> children;

    public Directory(String path, Component parent){
        this.path = path;
        this.parent = parent;
        this.children = new HashMap<String, Component>();
    }

    public void addFile(String name) {
        File file = new File(path, this);
        children.put(name, file);
    }

    public String getPath() {
        return path;
    }

    public Set<String> getChildrenNames() {
        return children.keySet();
    }

    public Component goToParent() {
        if(parent == null){
            return this;
        }
        return parent;
    }

    public Component goToChild(String name) throws DirectoryNotFoundException{
        if (name.equals("")){
            return this;
        }
        if(!children.containsKey(name)){
            throw new DirectoryNotFoundException();
        }
        return children.get(name);
    }

    public Boolean addDirectory(String name) {
        if(children.containsKey(name)){
            return Boolean.TRUE;
        }
        String newPath = path + "/"  + name;
        Directory directory = new Directory(newPath, this);
        children.put(name, directory);
        return Boolean.FALSE;
    }
}
