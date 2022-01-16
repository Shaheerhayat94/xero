package com.training.base;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BasePage {
	
	protected WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver  = driver;
		PageFactory.initElements(driver, this);	
	}
	
	public void waitforElement(WebElement element){

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void selectDropdown(WebDriver driver, By locator, String value){
		new Select (driver.findElement(locator)).selectByVisibleText(value); 
		}
	
	public static void switchTo(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	
	public void switchToWindow () {
		String oldWindow = driver.getWindowHandle();
		Set <String> getAllWindows = driver.getWindowHandles();
	    String[] getWindow = getAllWindows.toArray(new String[getAllWindows.size()]);
	    driver.switchTo().window(getWindow[1]);
	    driver.close();
	    driver.switchTo().window(oldWindow);
		}




}
	


