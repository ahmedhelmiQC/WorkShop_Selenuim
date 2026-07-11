package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class UploadFiles {


    public static String UserHome = System.getProperty("user.home");
    protected static WebDriver driver;
    protected static By uploadfile = By.id("file-upload");
    protected static By uploadBtn = By.id("file-submit");
    protected static By p = By.cssSelector("div[class=\"example\"] p");

    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.get("https://the-internet.herokuapp.com/upload");
    }

    public static WebElement webElement(By by) {
        return driver.findElement(by);
    }

    public static void clicking(By by) {
        driver.findElement(by).click();
    }

    public static void uploadfile(By by, String filepatch) {
        driver.findElement(by).sendKeys(filepatch);
    }

    public static String gettext(By by) {
        String text = driver.findElement(by).getText();
        System.out.println(text);
        return text;
    }

    public static void main(String[] args) {
        setup();
        //uploadfile(uploadfile, UserHome + File.separator + "Downloads\\export.xlsx");
        // clicking(uploadBtn);
        gettext(p);


    }

}
