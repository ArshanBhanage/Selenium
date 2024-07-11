package com.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class seleniumIntro {
    public static void main(String[] args) {

        // System.setProperty("webdriver.chrome.driver", "/Users/__aarshann__/Documents/Google Chrome for Testing");
        WebDriver webDriver = new ChromeDriver();

        webDriver.get("https://practicetestautomation.com/practice-test-login/");
        
        webDriver.findElement(By.id("username")).sendKeys("student");
        webDriver.findElement(By.id("password")).sendKeys("Password123");
        webDriver.findElement(By.id("submit")).click();

        System.out.println(webDriver.getTitle());
        System.out.println(webDriver.getCurrentUrl());
        
        // close method will only close the tab which is on focus
        webDriver.close();
        // quit method will close all the tabs opened by selenium
        webDriver.quit();

    }
}
