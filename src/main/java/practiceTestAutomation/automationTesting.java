package practiceTestAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class automationTesting {
    public static void main(String[] args) {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://rahulshettyacademy.com/AutomationPractice/");

        chromeDriver.findElement(By.id("name")).sendKeys("Arshan");
        chromeDriver.findElement(By.id("alertbtn")).click();
        System.out.println(chromeDriver.switchTo().alert().getText());
        chromeDriver.switchTo().alert().accept();

        chromeDriver.findElement(By.id("confirmbtn")).click();
        chromeDriver.switchTo().alert().dismiss();

        
    }
}
