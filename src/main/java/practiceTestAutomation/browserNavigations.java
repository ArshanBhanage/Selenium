package practiceTestAutomation;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class browserNavigations {
    public static void main(String[] args) {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().minimize();

        chromeDriver.get("https://www.google.com");
        chromeDriver.navigate().to("https://www.flipkart.com");
    }
}
