package org.example.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MousAction {


    public static By user1 = By.xpath("//div[@class='example']/div[1]");
    protected static WebDriver driver;
    protected static By rightClick = By.id("hot-spot");
    protected static Actions actions;

    public static void main(String[] args) {
        setup();
        // contextClick();
        hover();
    }

    public static void setup() {
        driver = new ChromeDriver();
        // driver.get("https://the-internet.herokuapp.com/context_menu");
        driver.get("https://the-internet.herokuapp.com/hovers");
        actions = new Actions(driver);

    }

    public static WebElement findwebelement(By by) {
        return driver.findElement(by);
    }

    public static void contextClick() {

        actions.contextClick(findwebelement(rightClick)).perform();
    }

    public static void hover() {
        actions.moveToElement(findwebelement(user1)).perform();
    }
}
