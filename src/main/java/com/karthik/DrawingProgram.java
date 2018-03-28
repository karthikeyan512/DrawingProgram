package com.karthik;

import com.karthik.model.Canvas;

import java.util.Scanner;

public class DrawingProgram {

    public static void main(String[] args) throws Exception {
        Canvas canvas = new Canvas();
        while (canvas.isCanvasActive()) {
            System.out.println("Enter command: ");
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();
            CommandsExecutor.executeCommand(canvas, userInput);
        }
    }
}
