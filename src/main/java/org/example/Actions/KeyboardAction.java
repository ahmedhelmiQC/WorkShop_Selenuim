package org.example.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardAction {

    protected static WebDriver driver;
    protected static By keys = By.id("target");

    protected static Actions actions;

    public static void main(String[] args) {
        setup();
        //keypress();

    }

    public static void setup() {
        driver = new ChromeDriver();
        //driver.get("https://the-internet.herokuapp.com/key_presses");
        driver.get("https://the-internet.herokuapp.com");

        actions = new Actions(driver);

    }

    public static WebElement findwebelement(By by) {
        return driver.findElement(by);
    }

    public static void keypress() {
        // actions.keyDown(Keys.ENTER).perform();
        actions.keyDown(Keys.SHIFT).sendKeys(findwebelement(keys), "test").perform();
    }


}
