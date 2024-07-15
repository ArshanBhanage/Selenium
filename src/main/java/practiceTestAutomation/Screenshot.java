package practiceTestAutomation;

import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

public class Screenshot{
    public static void main(String[] args) throws IOException{
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().deleteAllCookies();

        chromeDriver.get("https://www.google.com");

        File myScreenshot = ((TakesScreenshot)chromeDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(myScreenshot, new File("/Users/__aarshann__/testing projects/Selenium/src/main/java/images/myScreenshot.png"));
    }
}
