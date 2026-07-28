package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ifram {
    protected static WebDriver driver;

    protected static By iframleft = By.xpath("//body[contains(text(),'LEFT')]");
    protected static By iframmiddle = By.id("content");
    protected static By iframright = By.xpath("//body[contains(text(),'RIGHT')]");

    protected static By iframbottom = By.xpath("//body[contains(text(),'BOTTOM')]");


    public static void main(String[] args) {
        setup();
        nestedfram();
    }

    public static void setup() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
    }

    public static WebElement findwelement(By by) {
        return driver.findElement(by);
    }

    public static void nestedfram() {
        driver.switchTo().frame("frame-top").switchTo().frame("frame-left");
        System.out.println(findwelement(iframleft).getText());

        driver.switchTo().defaultContent().switchTo().frame("frame-top")
                .switchTo().frame("frame-middle");
        System.out.println(findwelement(iframmiddle).getText());

        driver.switchTo().defaultContent().switchTo().frame("frame-top")
                .switchTo().frame("frame-right");
        System.out.println(findwelement(iframright).getText());

        driver.switchTo().defaultContent().switchTo().frame("frame-bottom");
        System.out.println(findwelement(iframbottom).getText());


    }

}
