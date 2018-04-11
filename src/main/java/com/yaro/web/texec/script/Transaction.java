package com.yaro.web.texec.script;

import java.util.List;

/**
 * @author v-yshneykin
 * @since 4/3/18
 */
public class Transaction {

    private final String command;
    private final List<String> arguments;

    public Transaction(String command, List<String> arguments) {
        this.command = command;
        this.arguments = arguments;
    }

    public String getCommand() {
        return command;
    }

    public List<String> getArguments() {
        return arguments;
    }
}
