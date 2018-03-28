package com.karthik;

import com.karthik.model.Canvas;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CommandsExecutorTest {

    @Test
    public void testSingleCommand() {
        Canvas canvas = new Canvas();
        CommandsExecutor.executeCommand(canvas, "C 20 4");
        assertTrue(canvas.isCanvasInitialized());
    }

    @Test
    public void testMultipleCommands() {
        Canvas canvas = new Canvas();
        CommandsExecutor.executeCommands(canvas, Arrays.asList("C 20 4", "L 1 1 2 1"));
        assertTrue(canvas.isCanvasInitialized());
    }

    @Test
    public void testInvalidCommand() {
        Canvas canvas = new Canvas();
        CommandsExecutor.executeCommand(canvas, "C");
        assertFalse(canvas.isCanvasInitialized());
    }
}
