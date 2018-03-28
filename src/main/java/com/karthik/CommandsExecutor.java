package com.karthik;

import com.karthik.commands.Command;
import com.karthik.commands.HelpCommand;
import com.karthik.exception.InvalidCommandException;
import com.karthik.model.Canvas;

import java.util.Collections;
import java.util.List;

public class CommandsExecutor {
    public static void executeCommands(Canvas canvas, List<String> commands) {
        for (String fullCommand : commands) {
            Command command = CommandsFactory.getCommand(canvas, fullCommand);
            try {
                command.parseParameters();
                command.execute();
            } catch (InvalidCommandException e) {
                command = new HelpCommand(e.getMessage());
                command.execute();
            }
        }
    }

    static void executeCommand(Canvas canvas, String command) {
        executeCommands(canvas, Collections.singletonList(command));
        System.out.println(canvas);
    }
}
