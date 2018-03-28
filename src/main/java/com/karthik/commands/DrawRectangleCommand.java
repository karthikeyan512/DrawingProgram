package com.karthik.commands;

import com.karthik.CommandsBuilder;
import com.karthik.CommandsExecutor;
import com.karthik.exception.InvalidCommandException;
import com.karthik.model.Canvas;
import com.karthik.model.Point;

import java.util.List;

import static com.karthik.enums.UserCommand.DRAW_LINE;
import static com.karthik.utils.Constants.*;
import static com.karthik.utils.DrawingUtil.getCommandParams;

public class DrawRectangleCommand extends DrawingCommand {
    private Point point1;
    private Point point2;

    public DrawRectangleCommand(Canvas canvas, String fullCommand) {
        super(canvas, fullCommand);
    }

    @Override
    public void parseParameters() throws InvalidCommandException {
        if (!canvas.isCanvasInitialized()) {
            throw new InvalidCommandException(ERROR_CANVAS_NOT_INITIALIZED);
        }
        String splitString[] = getCommandParams(fullCommand);
        if (splitString.length != 5) {
            throw new InvalidCommandException(ERROR_INVALID_NUMBER_OF_ARGUMENTS);
        }
        try {
            point1 = new Point(Integer.parseInt(splitString[1]), Integer.parseInt(splitString[2]));
            point2 = new Point(Integer.parseInt(splitString[3]), Integer.parseInt(splitString[4]));
        } catch (NumberFormatException e) {
            throw new InvalidCommandException(ERROR_INVALID_POINTS_COORDINATES);
        }
        if (!point1.isValidPoint() || !point2.isValidPoint()) {
            throw new InvalidCommandException(ERROR_NOT_POSITIVE_POINT_COORDINATES);
        }
        if (!canvas.isPointInsideCanvas(point1) || !canvas.isPointInsideCanvas(point2)) {
            throw new InvalidCommandException(ERROR_POINT_OUTSIDE_CANVAS);
        }
    }

    @Override
    public void execute() {
        List<String> commands = new CommandsBuilder()
                .with(DRAW_LINE, point1.getX(), point1.getY(), point2.getX(), point1.getY())
                .with(DRAW_LINE, point2.getX(), point2.getY(), point1.getX(), point2.getY())
                .with(DRAW_LINE, point1.getX(), point1.getY(), point1.getX(), point2.getY())
                .with(DRAW_LINE, point2.getX(), point2.getY(), point2.getX(), point1.getY())
                .build();
        CommandsExecutor.executeCommands(canvas, commands);
    }

}
