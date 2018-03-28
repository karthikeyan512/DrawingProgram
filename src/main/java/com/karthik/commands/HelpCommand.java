package com.karthik.commands;

import com.karthik.exception.InvalidCommandException;
import org.apache.commons.lang3.StringUtils;

public class HelpCommand implements Command {

    private String exception;

    public HelpCommand() {
    }

    public HelpCommand(String exception) {
        this.exception = exception;
    }

    @Override
    public void parseParameters() throws InvalidCommandException {
    }

    @Override
    public void execute() {
        if (StringUtils.isNotEmpty(exception)) {
            System.out.println("Syntax error: " + exception);
        }
        System.out.println("Following are the valid commands syntax: ");
        System.out.println("Command 		Description");
        System.out.println("C w h           Creates a new canvas of width w and height h.");
        System.out.println("L x1 y1 x2 y2   Creates a new line from (x1,y1) to (x2,y2). Currently only horizontal or vertical lines are supported. Horizontal and vertical lines will be drawn using the 'x' character.");
        System.out.println("R x1 y1 x2 y2   Creates a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2). Horizontal and vertical lines will be drawn using the 'x' character.");
        System.out.println("B x y c         Fills the entire area connected to (x,y) with \"colour\" c. The behaviour of this is the same as that of the \"bucket fill\" tool in paint programs.");
        System.out.println("Q               Quits the program.");
    }

}
