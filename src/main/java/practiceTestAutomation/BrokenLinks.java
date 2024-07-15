package practiceTestAutomation;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {
    public static void main(String[] args) throws MalformedURLException, IOException{
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        chromeDriver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> footerLinks = chromeDriver.findElements(By.xpath("//div[@id='gf-BIG']//a"));

        // List<String> hrefs = footerLinks.stream()
        //                                     .map(link -> link.getAttribute("href"))
        //                                     .collect(Collectors.toList());
        List<String> hrefs = new ArrayList<>();
        for(WebElement w: footerLinks){
            hrefs.add(w.getAttribute("href"));
        }

        SoftAssert softAssert = new SoftAssert();

        Map<String, Integer> invalidUrls = new HashMap<>();

        for(String url: hrefs){
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int respCode = conn.getResponseCode();
            softAssert.assertTrue(respCode < 400, "Broken Link Found");
            if(respCode > 400){
                invalidUrls.put(url, respCode);
            }
        }

        System.out.println(invalidUrls);

        // ultimately fail all the soft assertions (broken links)
        softAssert.assertAll();


    }
}
