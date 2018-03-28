package com.karthik;

import com.karthik.enums.UserCommand;
import com.karthik.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class CommandsBuilder {
    private List<String> commandsList = new ArrayList<>();

    public CommandsBuilder with(UserCommand commandCode, Object... params) {
        StringBuilder s = new StringBuilder(commandCode.getCommandCode());
        for (Object param : params) {
            s.append(Constants.COMMAND_SEPARATOR);
            s.append(param.toString());
        }
        commandsList.add(s.toString());
        return this;
    }

    public List<String> build() {
        return commandsList;
    }
}
