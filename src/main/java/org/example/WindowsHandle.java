package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowsHandle {

    protected static WebDriver driver;

    protected static By clickhere = By.cssSelector("[class=example] >a");
    protected static By newtabe = By.cssSelector("[class='example'] > h3");


    public static void main(String[] args) {
        setup();
        multiwendows();
    }

    public static void setup() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
    }

    public static WebElement findwelement(By by) {
        return findwelement(by);
    }

    public static void multiwendows() {

        driver.findElement(clickhere).click();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> windowsiterator = windows.iterator();
        String parent = windowsiterator.next();
        String child = windowsiterator.next();
        driver.switchTo().window(child);
        System.out.println(driver.findElement(newtabe).getText());
        driver.switchTo().window(parent);
        System.out.println(driver.findElement(clickhere).getText());


    }
}
