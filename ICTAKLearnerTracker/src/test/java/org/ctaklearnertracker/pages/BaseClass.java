package org.ctaklearnertracker.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	
WebDriver driver;
	
	@BeforeTest
	public void configure() throws InterruptedException {
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://learnertracker.netlify.app/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
	}

	
	@AfterTest
	public void afterTest() {
		System.out.println("test case executed");
		driver.quit();
	}

}
