package com.salesforce.tests.fs;

public class cdCommand implements Command {

    public Component execute(Component component, String parameter) {
        Component newLocation = component;
        try{
            newLocation = parameter.equals("..") ? component.goToParent() : component.goToChild(parameter);
        } catch (DirectoryNotFoundException e){
            System.out.println("Directory not found");
        }

        return newLocation;
    }
}
