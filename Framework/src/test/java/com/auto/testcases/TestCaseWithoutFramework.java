package com.auto.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCaseWithoutFramework {
  @Test
  public void Test1() 
  {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\ait1hc\\WORKING\\TOOLS\\__SOFTS\\chromedriver.exe");
	  
	  WebDriver driver = new ChromeDriver();
	  
	  driver.get("https://ui.cogmento.com/");
	  
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  driver.findElement(By.name("email")).sendKeys("Selenium_50");
	  
	  driver.findElement(By.name("password")).sendKeys("Abcd@123456");
	  
	  driver.findElement(By.xpath("//div[text()='Login']")).click();
	  
	  driver.quit();
	  
  }
}
