package com.yaro.web.texec.script;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * @author v-yshneykin
 * @since 4/7/18
 */
public class ScriptReaderTest {

    @Test
    public void testReadingHappyPath() throws IOException, ValidationException {
        ScriptReader reader = new ScriptReader(new Validator());
        Script script = reader.read(
                ClassLoader.getSystemClassLoader().getResource("happy_path_script.txt").getPath());

        assertEquals("https://www.thousandeyes.com", script.getBaseUrl());
        assertEquals(60000, script.getExecTimeLimit());
        assertEquals(16, script.getTransactions().size());
        assertEquals("waitForElementPresent", script.getTransactions().get(4).getCommand());
        assertEquals("id=trigger-solutions-video", script.getTransactions().get(4).getArguments().get(0));
        assertEquals("10000", script.getTransactions().get(4).getArguments().get(1));
        assertEquals("click", script.getTransactions().get(5).getCommand());
        assertEquals("id=trigger-solutions-video", script.getTransactions().get(5).getArguments().get(0));
    }


}
