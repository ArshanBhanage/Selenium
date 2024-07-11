package practiceTestAutomation;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Ecommerce {
    public static void main(String[] args) {

        Map<String, Integer> hm = new HashMap<>();
        hm.put("Cucumber", 2);
        hm.put("Brocolli", 1);
        hm.put("Beetroot", 6);
        hm.put("Tomato", 100);

        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        chromeDriver.get("https://rahulshettyacademy.com/seleniumPractise");
        List<WebElement> products = chromeDriver.findElements(By.cssSelector("h4.product-name"));

        for(int i=0; i<products.size(); i++){
            String name = products.get(i).getText().split("-")[0].trim();
            
            if(hm.containsKey(name)){
                int quantity = hm.get(name);
                WebElement currentVeggie = chromeDriver.findElements(By.xpath("//div[@class='product-action']")).get(i);
                WebElement incrementBtn = chromeDriver.findElements(By.xpath("//a[@class='increment']")).get(i);
                for(int j=0; j<quantity-1; j++){
                    incrementBtn.click();
                }
                currentVeggie.click();
            }
        }

        chromeDriver.findElement(By.xpath("//a[@class='cart-icon']")).click();
        chromeDriver.findElement(By.xpath("//div[@class='cart-preview active']//button[@type='button']")).click();

        chromeDriver.findElement(By.xpath("//input[@placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
        chromeDriver.findElement(By.xpath("//button[@class='promoBtn']")).click();
        
        WebDriverWait explicitWait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
        Assert.assertEquals(chromeDriver.findElement(By.xpath("//span[@class='promoInfo']")).getText(), "Code applied ..!");
        chromeDriver.findElement(By.xpath("//button[text()='Place Order']")).click();


        chromeDriver.findElement(By.xpath("//select")).click();
        chromeDriver.findElement(By.xpath("//option[@value='El Salvador']")).click();
        chromeDriver.findElement(By.xpath("//input[@type='checkbox']")).click();
        chromeDriver.findElement(By.xpath("//button[text()='Proceed']")).click();

    }
}
