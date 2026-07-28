package org.example;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.IOException;

public class BroswerOptions {

    protected static WebDriver driver;
    //protected static EdgeOptions options;

    public static void main(String[] args) throws IOException {
        option();
    }

    public static void option() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        //  options.setBrowserVersion("latest");  Chrome
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new EdgeDriver(options);
        driver.get("https://www.google.com/");
    }

}
