package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {

    protected static WebDriver driver;

    protected static By button = By.tagName("button");
    protected static By msg = By.cssSelector("#finish > h4");

    public static void setup() {
        driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
    }

    public static WebElement findelement(By by) {
        return driver.findElement(by);
    }

    /// /                  Implicity Wait
    public static void implicityWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.findElement(button).click();
        String message = driver.findElement(msg).getText();
        System.out.println(message);
    }

    /// /                  Exmplicit Wait

    public static void exmplicitWait() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(button).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(msg));
        String message = driver.findElement(msg).getText();
        System.out.println(message);
    }

    /// /                  Fluent Wait

    public static void fuenttWait() {
        driver.findElement(button).click();

        Object wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class)
                .withMessage("element is visibil" + msg.toString())
                .until(d -> driver.findElement(msg).isDisplayed());

        String message = driver.findElement(msg).getText();
        System.out.println(message);
    }

    public static void main(String[] args) {

        setup();
        // implicityWait();
        //exmplicitWait();
        fuenttWait();
    }
}
