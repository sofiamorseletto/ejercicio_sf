package com.salesforce.tests.fs;

import java.util.Set;

public class lsCommand implements Command {

    public Component execute(Component component, String parameter) {
        Set<String> names = component.getChildrenNames();
        if(parameter.equals("[-r]")){
            //I should execute pwdCommand but I don't have enough time to do the corresponding changes
            if(names.size() != 0){
                for (String name: names){
                    try{
                        execute(component.goToChild(name), parameter);
                    } catch (DirectoryNotFoundException e){

                    }
                }
            }
        }
        for(String name : names){
            System.out.println(name);
        }
        return component;
    }
}
