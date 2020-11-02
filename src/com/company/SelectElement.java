package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectElement {
    WebDriver driver;

    @BeforeMethod
    public void initTests() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://mishpahug.co.il/");
        Thread.sleep(5000);
        driver.findElement(By.id("closedIntro")).click();
        Thread.sleep(2000);
    }

    @Test
    public void workWithSelectVisiableText() throws InterruptedException {
        Select holidays = new Select(driver.findElement(By.name("selectholidays")));
        holidays.selectByVisibleText("Shabbat (4)");
        Thread.sleep(2000);
    }

    @Test
    public void workWithSelectByValue() throws InterruptedException {
        Select holidays = new Select(driver.findElement(By.name("selectholidays")));
        holidays.selectByValue("Purim");
        Thread.sleep(2000);
    }

    @Test
    public void workWithSelectByIndex() throws InterruptedException {
        Select holidays = new Select(driver.findElement(By.name("selectholidays")));
        holidays.selectByIndex(2);
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
