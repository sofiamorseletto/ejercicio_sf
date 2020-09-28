package com.salesforce.tests.fs;

import java.util.Set;

public class lsCommand implements Command {

    public Component execute(Component component, String parameter) {
        Set<String> names = component.getChildrenNames();
        for (String name : names) {
            System.out.println(name);
        }
        if (parameter.equals("-r") && names.size() != 0) {
            for (String name : names) {
                try {
                    execute(component.goToChild(name), parameter);
                } catch (DirectoryNotFoundException e) {

                }
            }
        }
        return component;
    }
}
