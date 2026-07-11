package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MouseInteraction {

    protected static WebDriver driver;

    protected static WebElement Electronics;
    protected static WebElement SearchBar;


    public static void Setup()
    {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.get("https://www.noon.com/egypt-en/");
    }


    ///  ///////  HandlingAjexMouseInteraction ////

    public static void HandlingAjexMouseInteraction()
    {
        Electronics = driver.findElement(By.xpath("//span[contains(text(),'Electronics')]"));
        SearchBar = driver.findElement(By.id("search-input"));

        org.openqa.selenium.interactions.Actions a = new Actions(driver);
        a.moveToElement(Electronics).build().perform();
        a.moveToElement(SearchBar).click().keyDown(Keys.SHIFT).sendKeys("apple watch"+Keys.ENTER).build().perform();

    }

    public static void main(String[] args) {
        Setup();
         HandlingAjexMouseInteraction();
    }

}
