package com.karthik.model;

import java.io.Serializable;

public class Canvas implements Serializable {
    private Character[][] canvas;
    private boolean canvasActive = true;

    public Character[][] getCanvas() {
        return canvas;
    }

    public void setCanvas(Character[][] canvas) {
        this.canvas = canvas;
    }

    public boolean isCanvasActive() {
        return canvasActive;
    }

    public void setCanvasActive(boolean canvasActive) {
        this.canvasActive = canvasActive;
    }

    public boolean isCanvasInitialized() {
        return canvas != null;
    }

    public int getHeight() {
        return canvas.length - 2;
    }

    public int getWidth() {
        return canvas[0].length - 2;
    }

    public void setValue(Point point, char c) {
        if (isPointInsideCanvas(point)) {
            canvas[point.getY()][point.getX()] = c;
        }
    }

    public Character getValue(Point point) {
        if (isPointInsideCanvas(point)) {
            return canvas[point.getY()][point.getX()];
        }
        return null;
    }

    public boolean isPointInsideCanvas(Point point) {
        return isCanvasInitialized() && point.getY() < canvas.length - 1
                && point.getX() < canvas[point.getY()].length - 1;
    }

    @Override
    public String toString() {
        if (!isCanvasInitialized()) {
            return null;
        }
        StringBuilder s = new StringBuilder();
        for (Character[] row : canvas) {
            for (Character colChar : row) {
                s.append(colChar == null ? ' ' : colChar);
            }
            s.append("\r\n");
        }
        return s.toString();
    }

}