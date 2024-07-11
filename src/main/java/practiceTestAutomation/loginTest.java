package practiceTestAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class loginTest {
    public static void main(String[] args){
        
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().minimize();
        // WebDriver firefoxDriver = new FirefoxDriver();
        
        testLoginLogout(chromeDriver);
        // testLoginLogout(firefoxDriver);
        
    }

    private static void testLoginLogout(WebDriver driver){

        driver.get("https://practicetestautomation.com/practice-test-login/");
        
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitBtn = driver.findElement(By.id("submit"));

        usernameField.sendKeys("student");
        passwordField.sendKeys("Password123");
        
        // find element by css
        System.out.println(driver.findElement(By.cssSelector("header.site-header")).getText());

        // Thread.sleep when application is in a changing state (eg: popup, or navigation tabs, etc)
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Exception in thread:" + e);
        }
        
        // find element by id
        submitBtn.click();

        // find element by xpath (xpath is the class of the element) 
        // *** WE CAN USE INDEXES LIKE ARRAYS IF THERE ARE MULTIPLE ELEMENTS WITH SAME CLASS NAME ****
        //driver.findElement(By.xpath("//a[@class='wp-block-button__link has-text-color has-background has-very-dark-gray-background-color']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("header.site-header")).getText(), "HOME PRACTICE COURSES BLOG CONTACT");

        // Using Regular Expression
        WebElement logOutBtn = driver.findElement(By.xpath("//a[contains(@class, 'wp-block-button')]"));
        logOutBtn.click();

        System.out.println("Get Title:" + driver.getTitle());
        System.out.println("Get Current Url:" + driver.getCurrentUrl());

        // chromeDriver.quit();
        
    }
}
