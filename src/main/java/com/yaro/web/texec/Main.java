package com.yaro.web.texec;

import com.yaro.web.texec.command.OpenCommand;
import com.yaro.web.texec.script.Script;
import com.yaro.web.texec.script.ScriptReader;
import com.yaro.web.texec.script.ValidationException;
import com.yaro.web.texec.script.Validator;

import java.io.IOException;
import java.net.URL;

/**
 * @author v-yshneykin
 * @since 4/7/18
 */
public class Main {

    public static void main(String[] args) throws IOException, ValidationException {
        ScriptReader reader = new ScriptReader(new Validator());
        URL resource = ClassLoader.getSystemClassLoader()
                .getResource("tx_script.txt");
        if (resource == null) {
            throw new NullPointerException("tx_script.txt is not found");
        }
        Script script = reader.read(resource.getPath());

        OpenCommand command = new OpenCommand();
        command.execute(script.getBaseUrl(), script.getTransactions().get(0).getArguments());

    }
}
