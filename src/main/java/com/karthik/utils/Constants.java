package com.karthik.utils;

public interface Constants {
    char VERTICAL_BORDER_CHAR = '-';
    char HORIZONTAL_BORDER_CHAR = '|';
    char DRAW_LINE_CHAR = 'x';
    String COMMAND_SEPARATOR = " ";

    String ERROR_NO_COMMANDS_GIVEN = "No command was given";
    String ERROR_INVALID_NUMBER_OF_ARGUMENTS = "Invalid number of command arguments";
    String ERROR_INVALID_HEIGHT_WIDTH = "Invalid height and width";
    String ERROR_HEIGHT_WIDTH_NOT_POSITIVE = "Height and width should be positive non-zero value";
    String ERROR_CANVAS_NOT_INITIALIZED = "Canvas not initialized";
    String ERROR_INVALID_POINTS_COORDINATES = "Invalid values given for point co-ordinates";
    String ERROR_NOT_POSITIVE_POINT_COORDINATES = "Non-zero positive value should be given for point co-ordinates";
    String ERROR_NOT_STRAIGHT_LINE = "Only straight lines can be drawn";
    String ERROR_POINT_OUTSIDE_CANVAS = "Point specified is outside the canvas";
}
