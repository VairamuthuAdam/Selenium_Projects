package com.selenium.project;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitScreenShot {
	
public static void main(String[] args) throws IOException {
	
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\eclipse-workspace\\AdamSelenium\\Driver\\chromedriver.exe");
	
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://www.saucedemo.com/");
	
	//IMPLICIT WAIT
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	WebElement name = driver.findElement(By.id("user-name"));
	name.sendKeys("Vairamuthu");
	
	WebElement pass = driver.findElement(By.id("password"));
	pass.sendKeys("password");
	
	WebElement button = driver.findElement(By.id("login-button"));
	//EXPLICIT WAIT
//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.invisibilityOf(button));
	button.click();
	
	//SCREENSHOT
	TakesScreenshot tss = (TakesScreenshot)driver;
	File srcFile = tss.getScreenshotAs(OutputType.FILE);
	File desFile = new File("C:\\Users\\USER\\eclipse-workspace\\SeleniumProject\\Screenshot\\loginfailed.png");
	FileUtils.copyFile(srcFile, desFile);
	
	
	
	
	
	
	
	
	
//	String title = driver.getTitle();
//	
//	System.out.println(title);
//	
//	driver.manage().window().maximize();
//	
//	driver.navigate().to("https://www.instagram.com");
//	
//	driver.navigate().back();
//	
//	driver.navigate().forward();
//	
//	driver.close();
	
}

}
