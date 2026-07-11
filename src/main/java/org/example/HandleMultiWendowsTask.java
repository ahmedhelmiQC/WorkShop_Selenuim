package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class HandleMultiWendowsTask {

    protected static WebDriver driver;
    protected static WebElement newblank;
    protected static WebElement usernameelement;
    protected static WebElement agreementCheck;
    protected static WebElement psswordelment;
    protected static WebElement signBtn;


    protected static String Password = "Learning@830$3mK2";

    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
    }

    public static String getusername() {

        newblank = driver.findElement(By.partialLinkText("InterviewQues"));
        newblank.click();

        Set<String> windows = driver.getWindowHandles();

        Iterator<String> windowsIterator = windows.iterator();

        String ParentWindow = windowsIterator.next();
        String ChildWindow = windowsIterator.next();

        driver.switchTo().window(ChildWindow);
        String email = driver.findElement(By.xpath("//p[@class='im-para red']/strong/a")).getText();

        driver.switchTo().window(ParentWindow);

        /// / split mentor@rahulshettyacademy.com
        return email.split("mentor@")[1].split("\\.")[0];
        /// to get rahulshettyacademy
    }

    public static void login(String email) {
        usernameelement = driver.findElement(By.id("username"));
        usernameelement.sendKeys(email);

        agreementCheck = driver.findElement(By.id("terms"));
        agreementCheck.click();

        psswordelment = driver.findElement(By.id("password"));
        psswordelment.sendKeys(Password);

        signBtn = driver.findElement(By.name("signin"));
        signBtn.click();

    }


    public static void main(String[] args) {
        setup();
        getusername();

        login(getusername());
    }
}
