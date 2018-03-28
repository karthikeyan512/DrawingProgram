package com.karthik.commands;

import com.karthik.exception.InvalidCommandException;
import com.karthik.model.Canvas;

abstract class DrawingCommand implements Command {
    protected Canvas canvas;
    String fullCommand;

    DrawingCommand(Canvas canvas, String fullCommand) {
        this.canvas = canvas;
        this.fullCommand = fullCommand;
    }

    @Override
    public void parseParameters() throws InvalidCommandException {
    }

    @Override
    public void execute() {
    }

}
