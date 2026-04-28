package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {

    ///  Traverse_from_Parent_to_Child

    private WebDriver driver;

   /*
                            /// Regex  / Regular Expression

    public Task2()
    {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
    }

    public void getUsername()
    {
       /// Using cssSelector
       WebElement username = driver.findElement(By.cssSelector("input[placeholder*='name']"));
       username.sendKeys("ahmed helmi");

        /// Using ExPath
        WebElement password = driver.findElement(By.xpath("//input[contains(@placeholder,'Pass')]"));
        password.sendKeys("123456");

        /// Using ExPath
        WebElement signInBtn = driver.findElement(By.xpath("//button[contains(@class,'signIn')]"));
        signInBtn.click();
    }

    public static void main(String[] args) {

        Task2 test = new Task2();
        test.getUsername();
    }

    */

    public Task2()
    {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }
    public void ParentChild(){
        ///  From the parent div, select the label child, then get the input that comes right after it (its following sibling)
        WebElement LoginBtn = driver.findElement(By.xpath("//div/button[1]/following-sibling::button[1]"));

        System.out.println(LoginBtn.getText());
    }

    public void ChildParent(){
        /// Go from parent → child → back to parent → then to the next child using following-sibling

        WebElement anchertage= driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]/parent::div/parent::header/a[2]"));
        System.out.println(anchertage.getText());
    }
    public static void main(String[] args) {

        Task2 test = new Task2();
         test.ParentChild();
        test.ChildParent();


    }
}
