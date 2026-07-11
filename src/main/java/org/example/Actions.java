package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Actions {

    protected static WebDriver driver;
    protected static WebElement clickhere;

    public static void setup()
    {
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/windows");

    }

    public static void HandleMultiWendows()
    {
        clickhere= driver.findElement(By.cssSelector("a[href='/windows/new']"));
        clickhere.click();

        //implementation of Shifting between windows
        Set<String> windows = driver.getWindowHandles();

        // using Iterator to switch between wendows
        Iterator<String> windowsitertor= windows.iterator();

        String parentwendows = windowsitertor.next();
        String childwindows = windowsitertor.next();

        driver.switchTo().window(childwindows);

        String childwindowstext = driver.findElement(By.cssSelector("div[class='example'] h3")).getText();
        System.out.println(childwindowstext);
        driver.switchTo().window(parentwendows);
        String parentwindowstext = driver.findElement(By.cssSelector("div[class='example'] h3")).getText();
        System.out.println(parentwindowstext);



    }

    public static void main(String[] args) {
        setup();
        HandleMultiWendows();
    }

}
