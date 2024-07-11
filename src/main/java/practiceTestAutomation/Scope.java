package practiceTestAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {
    public static void main(String[] args){
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.w3schools.com");

        // two ways
        System.out.println(chromeDriver.findElements(By.xpath("//div[@id='footerwrapper']//a")).size());
        WebElement footerElement = chromeDriver.findElement(By.xpath("//div[@id='footerwrapper']"));
        System.out.println(footerElement.findElements(By.tagName("a")).size());
    }
}
