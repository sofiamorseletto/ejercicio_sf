package com.salesforce.tests.fs;

public interface Command {

    public Component execute(Component component, String parameter);
}
