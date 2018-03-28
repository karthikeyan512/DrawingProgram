package com.karthik.commands;

import com.karthik.CommandsBuilder;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static com.karthik.enums.UserCommand.CREATE_CANVAS;
import static com.karthik.enums.UserCommand.DRAW_LINE;
import static com.karthik.utils.Constants.*;

public class DrawLineCommandTest extends BaseCommandTest {

    @Parameters(name = "{0} - {1}")
    public static Collection<Object[]> testCases() {
        return Arrays.asList(new Object[][]{
                // Negative Cases
                {new CommandsBuilder()
                        .with(DRAW_LINE).build(),
                        ERROR_CANVAS_NOT_INITIALIZED, null},
                {new CommandsBuilder()
                        .with(CREATE_CANVAS, "20", "4")
                        .with(DRAW_LINE).build(),
                        ERROR_INVALID_NUMBER_OF_ARGUMENTS, null},
                {new CommandsBuilder()
                        .with(CREATE_CANVAS, "20", "4")
                        .with(DRAW_LINE, "1", "2").build(),
                        ERROR_INVALID_NUMBER_OF_ARGUMENTS, null},
                {new CommandsBuilder()
                        .with(CREATE_CANVAS, "20", "4")
                        .with(DRAW_LINE, "a", "b", "c", "d").build(),
                        ERROR_INVALID_POINTS_COORDINATES, null},
                {new CommandsBuilder()
                        .with(CREATE_CANVAS, "20", "4")
                        .with(DRAW_LINE, "-1", "-1", "-2", "-2").build(),
                        ERROR_NOT_POSITIVE_POINT_COORDINATES, null},
                {new CommandsBuilder()
                        .with(CREATE_CANVAS, "20", "4")
                        .with(DRAW_LINE, "0", "0", "0", "0").build(),
                        ERROR_NOT_POSITIVE_POINT_COORDINATES, null},
                {new CommandsBuilder()
                        .with(CREATE_CANVAS, "20", "4")
                        .with(DRAW_LINE, "18", "3", "21", "3").build(),
                        ERROR_POINT_OUTSIDE_CANVAS, null},
                {new CommandsBuilder()
                        .with(CREATE_CANVAS, "20", "4")
                        .with(DRAW_LINE, "5", "3", "5", "7").build(),
                        ERROR_POINT_OUTSIDE_CANVAS, null},
                {new CommandsBuilder()
                        .with(CREATE_CANVAS, "20", "4")
                        .with(DRAW_LINE, "1", "1", "3", "3").build(),
                        ERROR_NOT_STRAIGHT_LINE, null},
                {new CommandsBuilder()
                        .with(CREATE_CANVAS, "20", "4")
                        .with(DRAW_LINE, "1", "1", "3", "3").build(),
                        ERROR_NOT_STRAIGHT_LINE, null},
                //Positive Test
                {new CommandsBuilder()
                        .with(CREATE_CANVAS, "20", "4")
                        .with(DRAW_LINE, "1", "2", "6", "2").build(),
                        null, "draw_line_positive_1"},
                {new CommandsBuilder()
                        .with(CREATE_CANVAS, "20", "4")
                        .with(DRAW_LINE, "6", "3", "6", "4").build(),
                        null, "draw_line_positive_2"}});
    }

}
