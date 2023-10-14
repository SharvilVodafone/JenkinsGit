package com.selenium.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Test01 {
    WebDriver driver;
    @BeforeSuite
   public void setupEnvironment(){

    }
    @Test
    public void openWebsite(){
        System.out.println("Hello Jenkins");
        try{
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Sharvil\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://www.youtube.com");
        driver.manage().window().maximize();
        driver.findElements(By.xpath("//span[contains(text(),'Sign in')]/ancestor::a[@aria-label='Sign in']")).get(0).click();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("sharvil.joshi11@gmail.com");
        driver.findElement(By.xpath("//span[text()='Next']/ancestor::button")).click();
            System.out.println("Hello again Jenkins");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    @AfterTest
    public void newWindow(){
        String url = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://www.google.com");
        driver.switchTo().window(url);
        driver.navigate().to("https://www.google.com");
        driver.close();
        driver.quit();
    }
}

