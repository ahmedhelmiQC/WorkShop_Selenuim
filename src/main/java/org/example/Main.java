package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private WebDriver driver;

    private static final String FIRST_NAME = "Ahmed";

    private static final String LAST_NAME = "Helmi";

    private static final String EMAIL = "test@test.com";

    private static final String PASSWORD = "Test1234";

    private static final String CONFIRM_PASSWORD = "Test1234";


    private WebElement firstname;

    private WebElement lastname;

    private WebElement email;

    private WebElement password;

    private WebElement registerBtn;

    private WebElement registervalidationMassege;

    private WebElement logoutBtn;

    private WebElement loginBtn;


    public Main() {
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
    }

    public void register(){
        driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();

        firstname = driver.findElement(By.id("FirstName"));
        firstname.sendKeys(FIRST_NAME);

        lastname = driver.findElement(By.name("LastName"));
        lastname.sendKeys(LAST_NAME);

        email = driver.findElement(By.xpath("//input[@name='Email']"));
        email.sendKeys(EMAIL);

        password = driver.findElement(By.xpath("//*[@name='Password']"));
        password.sendKeys(PASSWORD);

        WebElement confirm_password = driver.findElement(By.cssSelector("input[name='ConfirmPassword']"));
        confirm_password.sendKeys(CONFIRM_PASSWORD);

        registerBtn = driver.findElement(By.cssSelector(".button-1.register-next-step-button"));
        registerBtn.click();
       // driver.quit();
    }

    public void registervalidatin(){
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/registerresult/1?returnUrl=/");
        registervalidationMassege = driver.findElement(By.className("result"));
        registervalidationMassege.isDisplayed();
    }

    public void logout(){
        logoutBtn = driver.findElement(By.xpath("//*[@a='https://demo.nopcommerce.com/logout']"));
    }

    public void login(String email , String password){
        driver.findElement(By.className("ico-login")).click();

        WebElement emailLogin = driver.findElement(By.xpath("//input[@name='Email']"));
        WebElement passwordLogin = driver.findElement(By.xpath("//*[@name='Password']"));
        emailLogin.sendKeys(email);
       passwordLogin.sendKeys(password);

       loginBtn = driver.findElement(By.xpath("//button[contains((text),'Log in')]"));
        loginBtn.click();
    }

    public static void main(String[] args) {

        Main test = new Main();
        test.register();
        test.registervalidatin();
       // test.logout();
        test.login(EMAIL,PASSWORD);

    }




}