package com.salesforce.tests.fs;

import java.util.HashMap;
import java.util.Scanner;

/**
 * The entry point for the Test program
 */
public class Main {

    static final String quit = "quit";

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        HashMap<String, Command> commands = setCommands();
        Component actualComponent = new Directory("root", null);
        Scanner scanner = new Scanner(System.in);
        String tokens[] = scanner.nextLine().split(" ");
        while (!tokens[0].equals(quit)) {
            String parameter = tokens.length > 1 ? tokens[1] : "";
            actualComponent = commands.get(tokens[0]).execute(actualComponent, parameter);
            tokens = scanner.nextLine().split(" ");
        }
    }

    private static HashMap<String, Command> setCommands() {
        HashMap<String, Command> commands = new HashMap<String, Command>();
        commands.put("pwd", new pwdCommand());
        commands.put("ls", new lsCommand());
        commands.put("mkdir", new mkdirCommand());
        commands.put("cd", new cdCommand());
        commands.put("touch", new touchCommand());
        return commands;
    }
}
