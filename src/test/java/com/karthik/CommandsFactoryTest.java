package com.karthik;

import com.karthik.commands.*;
import com.karthik.model.Canvas;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CommandsFactoryTest {

    @Test
    public void testEmptyCommand() {
        Command command = CommandsFactory.getCommand(new Canvas(), "");
        assertTrue("Factory returned wrong instance", command instanceof HelpCommand);
    }

    @Test
    public void testCreateCanvas() {
        Command command = CommandsFactory.getCommand(new Canvas(), "C");
        assertTrue("Factory returned wrong instance", command instanceof CreateCanvasCommand);
    }

    @Test
    public void testDrawLine() {
        Command command = CommandsFactory.getCommand(new Canvas(), "L");
        assertTrue("Factory returned wrong instance", command instanceof DrawLineCommand);
    }

    @Test
    public void testDrawRectangle() {
        Command command = CommandsFactory.getCommand(new Canvas(), "R");
        assertTrue("Factory returned wrong instance", command instanceof DrawRectangleCommand);
    }

    @Test
    public void testFillBucket() {
        Command command = CommandsFactory.getCommand(new Canvas(), "B");
        assertTrue("Factory returned wrong instance", command instanceof FillBucketCommand);
    }

    @Test
    public void testHelpCommand() {
        Command command = CommandsFactory.getCommand(new Canvas(), "H");
        assertTrue("Factory returned wrong instance", command instanceof HelpCommand);
    }

    @Test
    public void testQuitCommand() {
        Command command = CommandsFactory.getCommand(new Canvas(), "Q");
        assertTrue("Factory returned wrong instance", command instanceof QuitCommand);
    }

    @Test
    public void testInvalidCommand() {
        Command command = CommandsFactory.getCommand(new Canvas(), "Z");
        assertTrue("Factory returned wrong instance", command instanceof HelpCommand);
    }
}
