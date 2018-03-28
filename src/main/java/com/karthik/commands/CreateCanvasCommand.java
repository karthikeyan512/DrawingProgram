package com.karthik.commands;

import com.karthik.enums.Border;
import com.karthik.exception.InvalidCommandException;
import com.karthik.model.Canvas;
import com.karthik.utils.DrawingUtil;

import static com.karthik.utils.Constants.*;

public class CreateCanvasCommand extends DrawingCommand {
    private int height;
    private int width;

    public CreateCanvasCommand(Canvas canvas, String fullCommand) {
        super(canvas, fullCommand);
    }

    @Override
    public void parseParameters() throws InvalidCommandException {
        String splitString[] = DrawingUtil.getCommandParams(fullCommand);
        if (splitString.length != 3) {
            throw new InvalidCommandException(ERROR_INVALID_NUMBER_OF_ARGUMENTS);
        }
        try {
            width = Integer.parseInt(splitString[1]);
            height = Integer.parseInt(splitString[2]);
        } catch (NumberFormatException e) {
            throw new InvalidCommandException(ERROR_INVALID_HEIGHT_WIDTH);
        }
        if (height <= 0 || width <= 0) {
            throw new InvalidCommandException(ERROR_HEIGHT_WIDTH_NOT_POSITIVE);
        }
    }

    @Override
    public void execute() {
        canvas.setCanvas(new Character[height + 2][width + 2]);
        drawVerticalBorder(Border.TOP);
        drawVerticalBorder(Border.BOTTOM);
        drawHorizontalBorder(Border.LEFT);
        drawHorizontalBorder(Border.RIGHT);
    }

    private void drawVerticalBorder(Border border) {
        for (int i = 0; i <= canvas.getWidth() + 1; i++) {
            canvas.getCanvas()[border == Border.TOP ? 0 : canvas.getHeight() + 1][i] = VERTICAL_BORDER_CHAR;
        }
    }

    private void drawHorizontalBorder(Border border) {
        for (int i = 1; i < canvas.getHeight() + 1; i++) {
            canvas.getCanvas()[i][border == Border.LEFT ? 0 : canvas.getWidth() + 1] = HORIZONTAL_BORDER_CHAR;
        }
    }

}
