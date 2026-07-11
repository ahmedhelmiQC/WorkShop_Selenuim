package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDom {


    protected static WebDriver driver;
    protected static By shadow_host = By.id("shadow_host");
    protected static By input = By.cssSelector("[type='text']");

    protected static void setup() {
        driver = new ChromeDriver();
        driver.get("http://watir.com/examples/shadow_dom.html");
    }

    public static WebElement webElement(By by) {
        return driver.findElement(by);
    }

    public static void main(String[] args) {
        setup();
        driver.findElement(shadow_host).getShadowRoot().findElement(input).sendKeys("ahmed");
    }
}
