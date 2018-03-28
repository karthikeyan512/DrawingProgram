package com.karthik.commands;

import com.karthik.CommandsBuilder;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static com.karthik.enums.UserCommand.CREATE_CANVAS;
import static com.karthik.utils.Constants.*;

public class CreateCanvasCommandTest extends BaseCommandTest {

    @Parameters(name = "{0} - {1}")
    public static Collection<Object[]> testCases() {
        return Arrays.asList(new Object[][]{
                // Negative Cases
                {new CommandsBuilder().with(CREATE_CANVAS).build(), ERROR_INVALID_NUMBER_OF_ARGUMENTS, null},
                {new CommandsBuilder().with(CREATE_CANVAS, "1").build(), ERROR_INVALID_NUMBER_OF_ARGUMENTS, null},
                {new CommandsBuilder().with(CREATE_CANVAS, "1", "2", "3").build(), ERROR_INVALID_NUMBER_OF_ARGUMENTS, null},
                {new CommandsBuilder().with(CREATE_CANVAS, "a", "b").build(), ERROR_INVALID_HEIGHT_WIDTH, null},
                {new CommandsBuilder().with(CREATE_CANVAS, "-1", "-2").build(), ERROR_HEIGHT_WIDTH_NOT_POSITIVE, null},
                {new CommandsBuilder().with(CREATE_CANVAS, "0", "0").build(), ERROR_HEIGHT_WIDTH_NOT_POSITIVE, null},
                // Positive Cases
                {new CommandsBuilder().with(CREATE_CANVAS, "10", "10").build(), null, "canvas_positive_1"},
                {new CommandsBuilder().with(CREATE_CANVAS, "20", "4").build(), null, "canvas_positive_2"}});
    }

}
