package com.karthik.commands;

import com.karthik.exception.InvalidCommandException;

public interface Command {

    void parseParameters() throws InvalidCommandException;

    void execute();
}
