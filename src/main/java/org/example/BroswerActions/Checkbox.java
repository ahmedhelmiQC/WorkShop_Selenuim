package org.example.BroswerActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Checkbox {


    protected static WebDriver driver;

    protected static By checkbox = By.cssSelector("#checkboxes input[type='checkbox']");
    // protected static By checkbox2 = By.tagName(" checkbox 2 ");


    public static void main(String[] args) {
        setup();
        checkbox();
    }

    public static void setup() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    public static WebElement findwebelement(By by) {
        return driver.findElement(by);
    }

    public static void checkbox() {
        List<WebElement> checkboxes = driver.findElements(checkbox);

        // Uncheck the scend checkbox
        if (checkboxes.get(1).isSelected()) {
            checkboxes.get(1).click();
        }
        // Uncheck the first checkbox
        checkboxes.get(0).click();
        System.out.println(checkboxes.get(1).isSelected());
    }


    // Radio button


    public static class HandleMultiWendows {

        protected static WebDriver driver;
        protected static WebElement clickhere;

        public static void setup() {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get("https://the-internet.herokuapp.com/windows");

        }

        public static void HandleMultiWendows() {
            clickhere = driver.findElement(By.cssSelector("a[href='/windows/new']"));
            clickhere.click();

            //implementation of Shifting between windows
            Set<String> windows = driver.getWindowHandles();

            // using Iterator to switch between wendows
            Iterator<String> windowsitertor = windows.iterator();

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
}
