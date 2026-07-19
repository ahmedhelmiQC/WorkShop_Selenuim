package org.example.BroswerActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

    protected static WebDriver driver;
    protected static By dropdown = By.id("dropdown");

    public static void setup() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    public static WebElement findwebelement(By by) {
        return driver.findElement(by);
    }

    public static void dropDown() {
        new Select(driver.findElement(dropdown)).selectByVisibleText("Option 1");
    }

    public static void main(String[] args) {
        setup();
        dropDown();
    }
}
