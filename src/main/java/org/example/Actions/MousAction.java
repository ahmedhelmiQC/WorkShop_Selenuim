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

    protected static By sourceelement = By.id("column-a");
    protected static By destinationelement = By.id("column-b");

    protected static By scrollelement = By.partialLinkText("Status Codes");

    protected static Actions actions;

    public static void main(String[] args) {
        setup();
        // contextClick();
        //hover();
        //dragdrop();
        // clickandhold();
        scrolling();
    }

    public static void setup() {
        driver = new ChromeDriver();
        // driver.get("https://the-internet.herokuapp.com/context_menu");
        // driver.get("https://the-internet.herokuapp.com/hovers");
        //driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        driver.get("https://the-internet.herokuapp.com"); // scroll
        actions = new Actions(driver);

    }

    public static WebElement findwebelement(By by) {
        return driver.findElement(by);
    }

    /// ////            Context Click / Right Click
    public static void contextClick() {
        actions.contextClick(findwebelement(rightClick)).perform();
    }

    /// //////         Hover
    public static void hover() {
        actions.moveToElement(findwebelement(user1)).perform();
    }

    /// //          Drag and Drop
    public static void dragdrop() {
        WebElement source = findwebelement(sourceelement);
        WebElement destination = findwebelement(destinationelement);
        actions.dragAndDrop(source, destination).perform();
    }

    ///         Click and Hold
    public static void clickandhold() {
        WebElement source = findwebelement(sourceelement);
        WebElement destination = findwebelement(destinationelement);
        actions.clickAndHold(destination).moveToElement(source).perform(); // Click and Hold
        actions.clickAndHold(destination).moveToElement(source).release().perform(); // Click and Hold , drop
    }

    ///       Scrolling
    public static void scrolling() {
        actions.scrollToElement(findwebelement(scrollelement)).perform();
    }
}
