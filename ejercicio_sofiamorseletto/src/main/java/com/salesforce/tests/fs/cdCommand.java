package com.salesforce.tests.fs;

public class cdCommand implements Command {

    public Component execute(Component component, String parameter) {
        Component newLocation = component;
        String directories[] = parameter.split("/");
        for (String directory : directories){
            try{
                newLocation = parameter.equals("..") ? newLocation.goToParent() : newLocation.goToChild(directory);
            } catch (DirectoryNotFoundException e){
                System.out.println("Directory not found");
                return newLocation;
            }
        }
        return newLocation;
    }
}
