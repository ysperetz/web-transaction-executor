package com.yaro.web.texec.command;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * @author v-yshneykin
 * @since 4/7/18
 */
public class OpenCommand implements Command {

    private static final String NAME = "open";
    @Override
    public void execute(String basePath, List<String> arguments) {
        if (arguments == null || arguments.size() < 1) {
            throw new IllegalArgumentException("OpenCommand requires 1 argument: path");
        }
        WebDriver driver = new ChromeDriver();
        driver.get(basePath + arguments.get(0));
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }

    @Override
    public String getName() {
        return NAME;
    }
}
