package practiceTestAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo {
    public static void main(String[] args) {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://amazon.com");
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        WebElement signInBtn = chromeDriver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
        // signInBtn.click();

        Actions actions = new Actions(chromeDriver);
        actions.moveToElement(signInBtn).build().perform();

        WebElement searchInput = chromeDriver.findElement(By.id("twotabsearchtextbox"));
        actions.moveToElement(searchInput).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();

    }
}
