package org.example.BroswerActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

    protected static WebDriver driver;

    protected static By jsAlert = By.cssSelector("[onclick='jsAlert()']");
    protected static By jsConfirm = By.cssSelector("[onclick='jsConfirm()']");
    protected static By jsPrompt = By.cssSelector("[onclick='jsPrompt()']");

    public static void main(String[] args) {
        setup();
        jsConfirm();
        //jsdismiss();
        // jsPrompt();
    }

    public static void setup() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    public static WebElement findwelement(By by) {
        return driver.findElement(by);
    }

    public static void jsConfirm() {
        driver.findElement(jsAlert).click();
        String alerttext = driver.switchTo().alert().getText();
        System.out.println(alerttext);
        driver.switchTo().alert().accept();

    }

    public static void jsdismiss() {
        driver.findElement(jsConfirm).click();
        driver.switchTo().alert().dismiss();
    }

    public static void jsPrompt() {
        driver.findElement(jsPrompt).click();
        driver.switchTo().alert().sendKeys("ahmed");
        driver.switchTo().alert().accept();

    }
}
