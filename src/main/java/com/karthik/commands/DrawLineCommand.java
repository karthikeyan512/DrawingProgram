package com.karthik.commands;

import com.karthik.exception.InvalidCommandException;
import com.karthik.model.Canvas;
import com.karthik.model.Point;

import static com.karthik.utils.Constants.*;
import static com.karthik.utils.DrawingUtil.*;

public class DrawLineCommand extends DrawingCommand {
    private Point point1;
    private Point point2;

    public DrawLineCommand(Canvas canvas, String fullCommand) {
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
        if (!isStraightLine(point1, point2)) {
            throw new InvalidCommandException(ERROR_NOT_STRAIGHT_LINE);
        }
        if (!canvas.isPointInsideCanvas(point1) || !canvas.isPointInsideCanvas(point2)) {
            throw new InvalidCommandException(ERROR_POINT_OUTSIDE_CANVAS);
        }
    }

    @Override
    public void execute() {
        if (isHorizontalLine(point1, point2)) {
            drawHorizontalLine(point1, point2);
        }
        if (isVerticalLine(point1, point2)) {
            drawVerticalLine(point1, point2);
        }
    }

    private void drawHorizontalLine(Point point1, Point point2) {
        int startPoint = (point1.getY() < point2.getY()) ? point1.getY() : point2.getY();
        int endPoint = (point1.getY() < point2.getY()) ? point2.getY() : point1.getY();
        for (int i = startPoint; i <= endPoint; i++) {
            canvas.setValue(new Point(point1.getX(), i), DRAW_LINE_CHAR);
        }
    }

    private void drawVerticalLine(Point point1, Point point2) {
        int startPoint = (point1.getX() < point2.getX()) ? point1.getX() : point2.getX();
        int endPoint = (point1.getX() < point2.getX()) ? point2.getX() : point1.getX();
        for (int i = startPoint; i <= endPoint; i++) {
            canvas.setValue(new Point(i, point1.getY()), DRAW_LINE_CHAR);
        }
    }

}
