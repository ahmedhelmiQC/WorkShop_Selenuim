package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task7 {

    protected static WebDriver driver;

    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    protected static void addToCart()
    {
      List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        List<String> Items = new ArrayList<>(Arrays.asList("Cucumber", "Carrot", "Cauliflower"));

        for (int i = 0; i < products.size(); i++) {
            String productsName = products.get(i).getText();
            for(int item = 0; item < Items.size(); item++)
            {
                if (productsName.contains(Items.get(item)))
                {
                    driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
                    break;
                }
            }

        }

    }

    protected static void openCartItem()
    {
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

    }

    protected static void applyPromoCode(String promocode)
    {
        WebElement promoCode = driver.findElement(By.className("promoCode"));
        promoCode.sendKeys(promocode);
        driver.findElement(By.className("promoBtn")).click();
       WebElement promomassegevalid= driver.findElement(By.xpath(".//span[text()='Code applied ..!']"));
        System.out.println(promomassegevalid);
        promomassegevalid.isDisplayed();
    }

    protected static void placeOrder()
    {
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();
    }

    public static void main(String[] args)
    {
        setup();
        addToCart();
        openCartItem();
      //  applyPromoCode("rahulshettyacademy");
       // placeOrder();
    }
}
