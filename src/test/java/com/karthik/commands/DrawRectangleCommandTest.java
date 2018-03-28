package com.karthik.commands;

import com.karthik.CommandsBuilder;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static com.karthik.enums.UserCommand.CREATE_CANVAS;
import static com.karthik.enums.UserCommand.DRAW_RECTANGLE;
import static com.karthik.utils.Constants.*;

public class DrawRectangleCommandTest extends BaseCommandTest {

    @Parameters(name = "{0} - {1}")
    public static Collection<Object[]> testCases() {
        return Arrays.asList(new Object[][]{
                //Negative Cases
                {new CommandsBuilder()
                        .with(DRAW_RECTANGLE).build(),
                        ERROR_CANVAS_NOT_INITIALIZED, null},
                {new CommandsBuilder()
                        .with(CREATE_CANVAS, "20", "4")
                        .with(DRAW_RECTANGLE).build(),
                        ERROR_INVALID_NUMBER_OF_ARGUMENTS, null},
                {new CommandsBuilder()
                        .with(CREATE_CANVAS, "20", "4")
                        .with(DRAW_RECTANGLE, "1", "2").build(),
                        ERROR_INVALID_NUMBER_OF_ARGUMENTS, null},
                {new CommandsBuilder()
                        .with(CREATE_CANVAS, "20", "4")
                        .with(DRAW_RECTANGLE, "a", "b", "c", "d").build(),
                        ERROR_INVALID_POINTS_COORDINATES, null},
                {new CommandsBuilder()
                        .with(CREATE_CANVAS, "20", "4")
                        .with(DRAW_RECTANGLE, "-1", "-1", "-2", "-2").build(),
                        ERROR_NOT_POSITIVE_POINT_COORDINATES, null},
                {new CommandsBuilder()
                        .with(CREATE_CANVAS, "20", "4")
                        .with(DRAW_RECTANGLE, "0", "0", "0", "0").build(),
                        ERROR_NOT_POSITIVE_POINT_COORDINATES, null},
                {new CommandsBuilder()
                        .with(CREATE_CANVAS, "20", "4")
                        .with(DRAW_RECTANGLE, "18", "3", "21", "3").build(),
                        ERROR_POINT_OUTSIDE_CANVAS, null},
                {new CommandsBuilder()
                        .with(CREATE_CANVAS, "20", "4")
                        .with(DRAW_RECTANGLE, "5", "3", "5", "7").build(),
                        ERROR_POINT_OUTSIDE_CANVAS, null},
                //Positive Cases
                {new CommandsBuilder()
                        .with(CREATE_CANVAS, "20", "4")
                        .with(DRAW_RECTANGLE, "14", "1", "18", "3").build(),
                        null, "DRAW_RECTANGLE_positive_1"},
                {new CommandsBuilder()
                        .with(CREATE_CANVAS, "20", "4")
                        .with(DRAW_RECTANGLE, "6", "3", "6", "4").build(),
                        null, "DRAW_RECTANGLE_positive_2"}});
    }
    
}
