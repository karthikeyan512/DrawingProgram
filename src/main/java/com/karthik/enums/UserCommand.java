package com.karthik.enums;

public enum UserCommand {
    CREATE_CANVAS("C"),
    DRAW_LINE("L"),
    DRAW_RECTANGLE("R"),
    FILL_BUCKET("B"),
    QUIT("Q"),
    HELP("H");

    private String commandCode;

    UserCommand(String commandCode) {
        this.commandCode = commandCode;
    }

    public String getCommandCode() {
        return commandCode;
    }

}
