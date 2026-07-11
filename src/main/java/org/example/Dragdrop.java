package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Dragdrop {

   protected static WebDriver driver;
    protected static WebElement boxcontainer;
    protected static WebElement boxContainerDestnation;



   public static void Setup()
   {
       driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
       driver.get("https://jqueryui.com/droppable/");
   }

   public static void Dragdrop()
   {
    driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

    Actions actions = new Actions(driver);

    boxcontainer = driver.findElement(By.id("draggable"));
    boxcontainer.click();

    boxContainerDestnation = driver.findElement(By.id("droppable"));

    actions.dragAndDrop(boxcontainer,boxContainerDestnation).build().perform();

    driver.switchTo().defaultContent();
   }



   public static void main(String[] args) {
        Setup();
        Dragdrop();

    }
}
