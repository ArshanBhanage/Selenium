
package practiceTestAutomation;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class spicejet {
    public static void main(String[] args) throws InterruptedException{
        WebDriver chromeDriver = new ChromeDriver();

        chromeDriver.get("https://www.spicejet.com/");

        WebElement from = chromeDriver.findElement(By.xpath("//div[@data-testid='to-testID-origin']//div[@class='css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-1loqt21 r-13awgt0 r-ymttw5 r-tju18j r-5njf8e r-1otgn73']"));

        // select from location as bangalore
        from.click();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        chromeDriver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[10]/div[1]/div[2]")).click();

        // select to location as goa
        Thread.sleep(2000);
        chromeDriver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/div[3]/div[1]/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[24]")).click();

    }
}
