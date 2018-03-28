package com.karthik;

import com.karthik.commands.*;
import com.karthik.enums.UserCommand;
import com.karthik.model.Canvas;

import static com.karthik.utils.Constants.ERROR_NO_COMMANDS_GIVEN;

public class CommandsFactory {

    public static Command getCommand(Canvas canvas, String userCommand) {

        if (userCommand.length() == 0) {
            return new HelpCommand(ERROR_NO_COMMANDS_GIVEN);
        }
        String commandCode = userCommand.substring(0, 1);
        Command command;
        if (UserCommand.CREATE_CANVAS.getCommandCode().equals(commandCode)) {
            command = new CreateCanvasCommand(canvas, userCommand);
        } else if (UserCommand.DRAW_LINE.getCommandCode().equals(commandCode)) {
            command = new DrawLineCommand(canvas, userCommand);
        } else if (UserCommand.DRAW_RECTANGLE.getCommandCode().equals(commandCode)) {
            command = new DrawRectangleCommand(canvas, userCommand);
        } else if (UserCommand.FILL_BUCKET.getCommandCode().equals(commandCode)) {
            command = new FillBucketCommand(canvas, userCommand);
        } else if (UserCommand.QUIT.getCommandCode().equals(commandCode)) {
            command = new QuitCommand(canvas, userCommand);
        } else if (UserCommand.HELP.getCommandCode().equals(commandCode)) {
            command = new HelpCommand();
        } else {
            command = new HelpCommand("Command not found");
        }
        return command;
    }
}
