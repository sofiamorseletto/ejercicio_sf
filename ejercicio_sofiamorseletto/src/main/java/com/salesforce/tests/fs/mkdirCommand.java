package com.salesforce.tests.fs;

public class mkdirCommand implements Command {

    public Component execute(Component component, String parameter) {
        if(parameter.length() > 100){
            return component;
        }
        Boolean alreadyExists = component.addDirectory(parameter);
        if(alreadyExists.equals(Boolean.TRUE)){
            System.out.println("Directory already exists");
        }
        return component;
    }
}
