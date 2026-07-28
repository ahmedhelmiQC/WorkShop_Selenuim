package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Screenshots {

    protected static WebDriver driver;

    public static void main(String[] args) throws IOException {
        // takeScreenshoot();
        screenshootforelement();
    }

    public static void takeScreenshoot() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File distnation = new File("src/main/resources/google.png");
        try {
            FileUtils.copyFile(src, distnation);
        } catch (IOException e) {
            System.out.println("error" + e.getMessage());
        }
    }

    public static void screenshootforelement() throws IOException {
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        File scr = driver.findElement(By.cssSelector("svg.lnXdpd")).getScreenshotAs(OutputType.FILE);
        File dis = new File("src/main/resources/googlelogo.jpg");
        FileUtils.copyFile(scr, dis);
    }
}
