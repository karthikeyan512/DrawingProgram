package com.karthik.commands;

import com.karthik.exception.InvalidCommandException;
import com.karthik.model.Canvas;

public class QuitCommand extends DrawingCommand {
    public QuitCommand(Canvas canvas, String fullCommand) {
        super(canvas, fullCommand);
    }

    @Override
    public void parseParameters() throws InvalidCommandException {
    }

    @Override
    public void execute() {
        canvas.setCanvasActive(false);
    }

}
