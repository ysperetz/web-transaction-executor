package com.yaro.web.texec.command;

import java.util.List;

/**
 * @author v-yshneykin
 * @since 4/7/18
 */
public interface Command {

    public void execute(String basePath, List<String> arguments);

    public String getName();
}
