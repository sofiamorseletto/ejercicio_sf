package com.salesforce.tests.fs;

public class touchCommand implements Command {

    public Component execute(Component component, String parameter) {
        if(parameter.length() > 100){
            return component;
        }
        component.addFile(parameter);

        return component;
    }
}
