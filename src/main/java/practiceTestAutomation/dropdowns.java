package practiceTestAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdowns {
    public static void main(String[] args){
        WebDriver chromDriver = new ChromeDriver();
        chromDriver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // target static dropdowns
        WebElement staticDropdown = chromDriver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        WebElement passengerDropdown = chromDriver.findElement(By.id("divpaxinfo"));

        // used when elements have <select> tag 
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(1);
        System.out.println(dropdown.getFirstSelectedOption().getText());

        dropdown.selectByVisibleText("AED");
        System.out.println(dropdown.getFirstSelectedOption().getText());

        // when <option value= "INR"> is present
        dropdown.selectByValue("INR");
        System.out.println(dropdown.getFirstSelectedOption().getText());

        // passenger dropdown
        passengerDropdown.click();

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(e);
        }

        int clicks = 0;
        while(clicks < 2){
            chromDriver.findElement(By.id("hrefIncAdt")).click();
            clicks++;
        }

        chromDriver.findElement(By.id("btnclosepaxoption")).click();

        // chromDriver.quit();
    }
}
