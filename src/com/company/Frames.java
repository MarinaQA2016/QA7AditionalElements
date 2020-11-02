package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Frames {
    WebDriver driver;
    @BeforeMethod
    public void initTests() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
        Thread.sleep(5000);
    }

    @Test
    public  void workWithFrames(){
        //--Inside default content----
        System.out.println("Button 'Run' text: " + driver
                .findElement(By.xpath("//button[contains(text(),'Run')]")).getText());
        //System.out.println("Header h2: " + driver.findElement(By.tagName("h2")).getText());
        //System.out.println("Header h1 in box: " + driver.findElement(By.tagName("h1")).getText());
        driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
        System.out.println("Header h2: " + driver.findElement(By.tagName("h2")).getText());
        //System.out.println("Header h1 in box: " + driver.findElement(By.tagName("h1")).getText());
        /*System.out.println("Button 'Run' text: " + driver
                .findElement(By.xpath("//button[contains(text(),'Run')]")).getText());*/
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Iframe Example']")));
        System.out.println("Header h1 in box: " + driver.findElement(By.tagName("h1")).getText());
        //System.out.println("Header h2: " + driver.findElement(By.tagName("h2")).getText());
        //driver.switchTo().parentFrame();
        //System.out.println("Header h2: " + driver.findElement(By.tagName("h2")).getText());
        driver.switchTo().defaultContent();
        System.out.println("Button 'Run' text: " + driver
                .findElement(By.xpath("//button[contains(text(),'Run')]")).getText());

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
