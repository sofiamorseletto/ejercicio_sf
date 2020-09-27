package com.salesforce.tests.fs;

public class pwdCommand implements Command {

    public Component execute(Component component, String parameter){
        System.out.println(component.getPath());
        return component;
    }
}
