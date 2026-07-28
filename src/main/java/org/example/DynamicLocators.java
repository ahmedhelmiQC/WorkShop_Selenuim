package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DynamicLocators {

    ///  a dynamic locator usually means the locator is created at runtime based on a variable value rather than hardcoding a fixed element.
    
    /// This is useful because one method can handle multiple elements without creating a separate locator for every value.
    protected static WebDriver driver;
    protected static Actions actions;

    public static void main(String[] args) {
        setup();
        DL();
        chooseCategory("Contribute");
        chooseSubCategory("CLA");
    }

    public static void setup() {
        driver = new ChromeDriver();
        driver.get("https://jqueryui.com/");
    }

    public static void DL() {

        actions.moveToElement(driver.findElement(By.cssSelector("ul[class='links']")))
                .perform();
    }

    ///   a dynamic locator
    public static void chooseCategory(String option) {
        driver.findElement(By.xpath("//a[.='" + option + "']")).click();
    }

    public static void chooseSubCategory(String option) {
        driver.findElement(By.xpath("//a[.='" + option + "']")).click();
    }
}
