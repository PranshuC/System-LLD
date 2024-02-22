package com.pranshu.splitwise.commands;

// Command Design Pattern - for CLI application
public interface Command {
    boolean matches(String input);

    void execute(String input);
}
