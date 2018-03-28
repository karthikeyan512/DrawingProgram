package com.karthik.commands;

import com.karthik.CommandsBuilder;
import com.karthik.CommandsExecutor;
import com.karthik.model.Canvas;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static com.karthik.enums.UserCommand.CREATE_CANVAS;
import static com.karthik.enums.UserCommand.QUIT;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class QuitCommandTest {

    @Parameters(name = "{0} - {1}")
    public static Collection<Object[]> testCases() {
        return Arrays.asList(new Object[][]{
                {new CommandsBuilder()
                        .with(QUIT).build(), false},
                {new CommandsBuilder()
                        .with(CREATE_CANVAS, "20", "4")
                        .with(QUIT).build(),
                        false},
                {new CommandsBuilder()
                        .with(CREATE_CANVAS, "20", "4").build(),
                        true}
        });
    }

    @Parameter
    public List<String> commands;

    @Parameter(1)
    public boolean canvasActive;

    private Canvas canvas = new Canvas();

    @Test
    public void testCommand() throws Exception {
        CommandsExecutor.executeCommands(canvas, commands);
        assertEquals("Canvas status mismatch", canvasActive, canvas.isCanvasActive());
    }
}
