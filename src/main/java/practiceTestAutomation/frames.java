package practiceTestAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class frames {
    public static void main(String[] args) {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://ui.vision/demo/iframes");

        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println(chromeDriver.findElements(By.tagName("iframe")).size());

        chromeDriver.switchTo().frame(chromeDriver.findElement(By.id("twitter-widget-0")));
        WebElement iframeBtn = chromeDriver.findElement(By.xpath("//a[@class='css-175oi2r r-sdzlij r-1phboty r-rs99b7 r-lrvibr r-k200y r-1j93nrh r-1mnahxq r-19yznuf r-64el8z r-1fkl15p r-o7ynqc r-6416eg r-1ny4l3l r-1loqt21']"));
        iframeBtn.click();
        chromeDriver.switchTo().defaultContent();

    }
}
