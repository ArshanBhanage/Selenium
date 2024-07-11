package practiceTestAutomation;

import java.util.Set;
import java.time.Duration;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class parentChildWindows {
    public static void main(String[] args) {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        chromeDriver.get("https://rahulshettyacademy.com/loginpagePractise/#/");
        
        chromeDriver.findElement(By.xpath("//a[@class='blinkingText']")).click();
        
        Set<String> windows = chromeDriver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();

        chromeDriver.switchTo().window(childWindow);
        String emailId = chromeDriver.findElement(By.xpath("//p[@class='im-para red']")).getText().split(" ")[4];
        System.out.println(emailId);

        chromeDriver.switchTo().window(parentWindow);
        chromeDriver.findElement(By.id("username")).sendKeys(emailId);
        chromeDriver.findElement(By.id("password")).sendKeys("learning");
        //chromeDriver.findElement(By.xpath("//input[@value='user']")).click();
        chromeDriver.findElement(By.id("signInBtn")).click();
        chromeDriver.findElement(By.id("terms")).click();

    }
}
