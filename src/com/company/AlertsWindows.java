package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsWindows {
    WebDriver driver;

    @BeforeMethod
    public void initTests() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("file:///C:/Marina/TelRan/QA%20Courses/Selenium/AlertsDemo.html");
        Thread.sleep(2000);
    }

    @Test
    public void workWithSimpleAlert() throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Simple Alert')]")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
    }

    @Test
    public void workWithConfirmBox() throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Confirm Box')]")).click();
        Thread.sleep(2000);
        //--Pressing on OK button-----
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        System.out.println("Message after pressing OK button: "+ driver.findElement(By.id("demoConfirm")).getText());
        //--Pressing on Cancel button-----
        driver.findElement(By.xpath("//button[contains(text(),'Confirm Box')]")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);
        System.out.println("Message after pressing OK button: "+ driver.findElement(By.id("demoConfirm")).getText());
    }

    @Test
    public void workWithPrompt() throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Prompt box')]")).click();
        Thread.sleep(2000);
        //--- Change field value
        driver.switchTo().alert().sendKeys("Ivan Ivanov");
        Thread.sleep(2000);
        //--Pressing on OK button-----
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        System.out.println("Message after pressing OK button: "+ driver.findElement(By.id("demoPrompt")).getText());
        //--Pressing on Cancel button-----
        driver.findElement(By.xpath("//button[contains(text(),'Prompt box')]")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);
        System.out.println("Message after pressing OK button: "+ driver.findElement(By.id("demoPrompt")).getText());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
