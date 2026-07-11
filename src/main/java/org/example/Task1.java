package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.testmuai.com/selenium-playground/");
        driver.findElement(By.linkText("Ajax Form Submit")).click();
        driver.findElement(By.id("title")).sendKeys("ahmed helmi");
        driver.findElement(By.id("description")).sendKeys("Hello");
        driver.findElement(By.id("btn-submit")).click();
    }


}
