package com.karthik.commands;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.karthik.CommandsFactory;
import com.karthik.exception.InvalidCommandException;
import com.karthik.model.Canvas;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import java.net.URL;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public abstract class BaseCommandTest {
    @Parameter
    public List<String> commands;

    @Parameter(1)
    public String exceptionText;

    @Parameter(2)
    public String expectedFile;

    private Canvas canvas = new Canvas();

    @Test
    public void testCommand() throws Exception {
        String actualException = null;
        for(String commandText : commands) {
            Command command = CommandsFactory.getCommand(canvas, commandText);
            try {
                command.parseParameters();
                command.execute();
            } catch (InvalidCommandException e) {
                actualException = e.getMessage();
                break;
            }
        }
        if (StringUtils.isNotEmpty(exceptionText)) {
            assertEquals("Exception mismatch", exceptionText, actualException);
        } else {
            URL url = Resources.getResource(getClass(), expectedFile);
            String expected = Resources.toString(url, Charsets.UTF_8);
            assertEquals("Expected canvas state mismatch", expected, canvas.toString());
        }
    }

}

