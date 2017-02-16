/**
 * 
 */
package com.talkable.product;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.Before;
import org.junit.Test;
/**
 * @author igor
 *
 */
public class Tests {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		

	}
	
	@Test
	public void setingUp ()
	{
		//DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		//capabilities.setCapability("marionette", true);
		//System.setProperty("webdriver.chrome.driver", "/home/igor/Downloads/chromedriver");
		//WebDriver driver = new ChromeDriver();
		// Geckodriver download location
		System.setProperty("webdriver.gecko.driver", "/home/igor/Downloads/geckodriver");
		//WebDriver driver = new FirefoxDriver();
		// Create Firefox Driver with Marionette capabilities
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		WebDriver driver = new FirefoxDriver(capabilities);
		//WebDriver driver = new MarionetteDriver();
		
		//WebDriver driver = new FirefoxDriver(capabilities);
		// Set implicit wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://void.talkable.com");
		
		driver.findElement(By.linkText("Login")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		driver.findElement(By.id("user_session_email")).sendKeys("igor.palamarchuk@talkable.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("user_session_password")).sendKeys("($#()%,!)R3mb00");
		driver.findElement(By.className("button is-large is-block mrm")).click();
		
		System.out.println("Login Results Page Title: " + driver.getTitle());
		//System.out.println("Search Results Count Text:" + driver.findElement(By.id("searchCount")).getText());
		//Thread.sleep(2000);
		
		driver.close();
		driver.quit();
		
	}

}
