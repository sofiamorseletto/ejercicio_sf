package com.salesforce.tests.fs;

import java.io.FileNotFoundException;
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
        try {
            java.io.File previousState = new java.io.File("archivo.txt");
            Scanner fileScanner = new Scanner(previousState);
            String tokens[];
            while (fileScanner.hasNextLine()) {
                tokens = fileScanner.nextLine().split(" ");
                actualComponent = executeCommands(commands, tokens, actualComponent);
            }
        } catch (FileNotFoundException e) {
        }

        Scanner scanner = new Scanner(System.in);
        String tokens[] = scanner.nextLine().split(" ");
        while (!tokens[0].equals(quit)) {
            actualComponent = executeCommands(commands, tokens, actualComponent);
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

    private static Component executeCommands(HashMap<String, Command> commands,String[] tokens, Component actualComponent) {
        String parameter = tokens.length > 1 ? tokens[1] : "";
        if (tokens[0].equals("ls") && !parameter.equals("")) {
            actualComponent = parameter.equals("-r") ? commands.get(("pwd")).execute(actualComponent, parameter) : commands.get(("cd")).execute(actualComponent, parameter);
        }
        return commands.get(tokens[0]).execute(actualComponent, parameter);
    }
}
