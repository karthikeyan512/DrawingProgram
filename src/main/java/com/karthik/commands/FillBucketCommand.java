package com.karthik.commands;

import com.karthik.exception.InvalidCommandException;
import com.karthik.model.Canvas;
import com.karthik.model.Point;
import com.karthik.utils.DrawingUtil;

import java.util.LinkedList;
import java.util.Queue;

import static com.karthik.utils.Constants.*;
import static com.karthik.utils.DrawingUtil.*;

public class FillBucketCommand extends DrawingCommand {
    private Point point;
    private char newChar;

    public FillBucketCommand(Canvas canvas, String fullCommand) {
        super(canvas, fullCommand);
    }

    @Override
    public void parseParameters() throws InvalidCommandException {
        if (!canvas.isCanvasInitialized()) {
            throw new InvalidCommandException(ERROR_CANVAS_NOT_INITIALIZED);
        }
        String splitString[] = DrawingUtil.getCommandParams(fullCommand);
        if (splitString.length != 4) {
            throw new InvalidCommandException(ERROR_INVALID_NUMBER_OF_ARGUMENTS);
        }
        newChar = splitString[3].charAt(0);
        try {
            point = new Point(Integer.parseInt(splitString[1]), Integer.parseInt(splitString[2]));
        } catch (NumberFormatException e) {
            throw new InvalidCommandException(ERROR_INVALID_POINTS_COORDINATES);
        }
        if (!point.isValidPoint()) {
            throw new InvalidCommandException(ERROR_NOT_POSITIVE_POINT_COORDINATES);
        }
        if (!canvas.isPointInsideCanvas(point)) {
            throw new InvalidCommandException(ERROR_POINT_OUTSIDE_CANVAS);
        }
    }

    @Override
    public void execute() {
        Character oldChar = canvas.getValue(point);
        Queue<Point> linkedList = new LinkedList<>();
        linkedList.add(point);
        while (!linkedList.isEmpty()) {
            Point currentPoint = linkedList.poll();
            if (canvas.getValue(currentPoint) == oldChar) {
                canvas.setValue(currentPoint, newChar);
            }
            Point abovePoint = getAbovePoint(currentPoint);
            Point belowPoint = getBelowPoint(currentPoint);
            Point rightPoint = getRightPoint(currentPoint);
            Point leftPoint = getLeftPoint(currentPoint);
            if (canvas.isPointInsideCanvas(abovePoint) && canvas.getValue(abovePoint) == oldChar) {
                linkedList.add(abovePoint);
            }
            if (canvas.isPointInsideCanvas(belowPoint) && canvas.getValue(belowPoint) == oldChar) {
                linkedList.add(belowPoint);
            }
            if (canvas.isPointInsideCanvas(leftPoint) && canvas.getValue(leftPoint) == oldChar) {
                linkedList.add(leftPoint);
            }
            if (canvas.isPointInsideCanvas(rightPoint) && canvas.getValue(rightPoint) == oldChar) {
                linkedList.add(rightPoint);
            }
        }
    }

}
