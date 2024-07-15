package practiceTestAutomation;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.*;

public class JsExecutor {
    public static void main(String[] args) {
        WebDriver chromeDriver = new ChromeDriver();
        JavascriptExecutor jse = (JavascriptExecutor)chromeDriver;

        chromeDriver.get("https://rahulshettyacademy.com/AutomationPractice/");
        jse.executeScript("window.scrollBy(0,800)");
        jse.executeScript("document.querySelector('.tableFixHead').scrollTop=500");

        List<WebElement> e = chromeDriver.findElements(By.xpath("//div[@class='tableFixHead']//tr//td[4]"));
        for(int i=0; i<e.size(); i++){
            System.out.println(e.get(i).getText());
        }
    }
}
