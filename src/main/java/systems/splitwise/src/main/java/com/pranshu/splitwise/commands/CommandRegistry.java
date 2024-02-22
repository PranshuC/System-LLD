package com.pranshu.splitwise.commands;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * In the main() method, just call CommandRegistry.execute(<COMMAND_NAME>)
 * to start interacting with the application as Command Line Interface (CLI)
 */
@Component
public class CommandRegistry {
    private List<Command> commands = new ArrayList<>();

    public CommandRegistry(RegisterUserCommand registerUserCommand) {
        commands.add(registerUserCommand);
    }

    public boolean registerCommand(Command command) {
        if (commands.contains(command)) {
            return false;
        }
        commands.add(command);
        return true;
    }

    public boolean unregister(Command command) {
        commands.remove(command);
        return true;
    }

    // Iterate over list of commands;
    // when matches command name, execute
    public void execute(String input) {
        for (Command command : commands) {
            if (command.matches(input)) {
                command.execute(input);
                return;
            }
        }
    }
}
