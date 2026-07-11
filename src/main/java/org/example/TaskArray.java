package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class TaskArray {

    protected static WebDriver driver;


    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    public static void addtocart(String[] productsNeeded) {
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        int counter = 0;

        for (int i = 0; i < products.size(); i++) {
            String itemName = products.get(i).getText().split("-")[0].trim();
            List itemlist = Arrays.asList(productsNeeded);

            if (itemlist.contains(itemName)) {
                System.out.println(itemlist);
                counter++;

                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                if (counter == productsNeeded.length) {
                    break;
                }
            }
        }

    }


    public static void main(String[] args) {
        setup();
        String[] productesNeeded = {"Potato","Brocolli", "Tomato", "Beans"};
        addtocart(productesNeeded);
    }
}
