package practiceTestAutomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalenderEcommerce {
    public static void main(String[] args) {
        String month = "6";
        String date = "12";
        String year = "2017";
        String formattedDate = month+"/"+date+"/"+year;

        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        chromeDriver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        WebElement datePickerBtn = chromeDriver.findElement(By.xpath("//button[@class='react-date-picker__calendar-button react-date-picker__button']"));
        datePickerBtn.click();

        WebElement yearTitle = chromeDriver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']"));
        yearTitle.click();
        
        WebElement prevYearBtn = chromeDriver.findElement(By.xpath("//button[@class='react-calendar__navigation__arrow react-calendar__navigation__prev-button']"));
        while(!yearTitle.getText().equals(year)){
            prevYearBtn.click();
        }

        List<WebElement> months = chromeDriver.findElements(By.xpath("//div[@class='react-calendar__year-view__months']//button"));
        
        months.get(Integer.parseInt(month)-1).click();

        List<WebElement> dates = chromeDriver.findElements(By.xpath("//div[@class='react-calendar__month-view__days']//button"));

        for(WebElement d: dates){
            if(d.getText().equals(date)){
                d.click();
                break;
            }
        }

        List<WebElement> chosenDates = chromeDriver.findElements(By.xpath("//div[@class='react-date-picker__wrapper']//input"));
        String chosenMonth = chosenDates.get(1).getAttribute("value");
        String chosenDate = chosenDates.get(2).getAttribute("value");
        String chosenYear = chosenDates.get(3).getAttribute("value");

        String formattedChosenDates = chosenMonth + "/" + chosenDate + "/" + chosenYear;

        Assert.assertEquals(formattedChosenDates, formattedDate);

    }
}
