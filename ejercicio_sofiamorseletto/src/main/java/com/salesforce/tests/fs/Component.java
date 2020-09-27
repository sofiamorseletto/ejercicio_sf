package com.salesforce.tests.fs;

import java.util.Set;

public interface Component {

    Component goToParent();
    Component goToChild(String name) throws DirectoryNotFoundException;
    String getPath();
    Boolean addDirectory(String name);
    void addFile(String name);
    Set<String> getChildrenNames();
}
