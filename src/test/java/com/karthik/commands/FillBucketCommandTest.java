package com.karthik.commands;

import com.karthik.CommandsBuilder;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static com.karthik.enums.UserCommand.*;
import static com.karthik.utils.Constants.*;

public class FillBucketCommandTest extends BaseCommandTest {

    @Parameters(name = "{0} - {1}")
    public static Collection<Object[]> testCases() {
        return Arrays.asList(new Object[][]{
                //Negative Cases
                {new CommandsBuilder()
                        .with(FILL_BUCKET).build(),
                        ERROR_CANVAS_NOT_INITIALIZED, null},
                {new CommandsBuilder()
                        .with(CREATE_CANVAS, "20", "4")
                        .with(FILL_BUCKET).build(),
                        ERROR_INVALID_NUMBER_OF_ARGUMENTS, null},
                {new CommandsBuilder()
                        .with(CREATE_CANVAS, "20", "4")
                        .with(FILL_BUCKET, "1", "2").build(),
                        ERROR_INVALID_NUMBER_OF_ARGUMENTS, null},
                {new CommandsBuilder()
                        .with(CREATE_CANVAS, "20", "4")
                        .with(FILL_BUCKET, "a", "b", "c").build(),
                        ERROR_INVALID_POINTS_COORDINATES, null},
                {new CommandsBuilder()
                        .with(CREATE_CANVAS, "20", "4")
                        .with(FILL_BUCKET, "-1", "-1", "o").build(),
                        ERROR_NOT_POSITIVE_POINT_COORDINATES, null},
                {new CommandsBuilder()
                        .with(CREATE_CANVAS, "20", "4")
                        .with(FILL_BUCKET, "21", "3", "o").build(),
                        ERROR_POINT_OUTSIDE_CANVAS, null},
                {new CommandsBuilder()
                        .with(CREATE_CANVAS, "20", "4")
                        .with(FILL_BUCKET, "5", "5", "o").build(),
                        ERROR_POINT_OUTSIDE_CANVAS, null},
                //Positive Cases
                {new CommandsBuilder()
                        .with(CREATE_CANVAS, "20", "4")
                        .with(FILL_BUCKET, "14", "1", "c").build(),
                        null, "fill_bucket_positive_1"},
                {new CommandsBuilder()
                        .with(CREATE_CANVAS, "20", "4")
                        .with(DRAW_LINE, "1", "2", "6", "2")
                        .with(DRAW_LINE, "6", "3", "6", "4")
                        .with(DRAW_RECTANGLE, "14", "1", "18", "3")
                        .with(FILL_BUCKET, "10", "3", "o").build(),
                        null, "fill_bucket_positive_2"}});
    }
    
}
