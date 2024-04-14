package org.ictaklearnertracker.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	@FindBy(xpath="//input[@id='username']")
	WebElement uname;
	@FindBy(xpath="//input[@id='password']")
	WebElement pass;
	@FindBy(xpath="//button[text()='Login']")
	WebElement loginbtn;
	@FindBy(xpath="//p[text()='ICTAK - Learner Tracker']")
	WebElement expected;
	
	//String actual="ICTAK - Learner Tracker";
	
	public LoginPage(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver2, this);
	}



	public void loginAction(String u , String p) throws InterruptedException  {
		  uname.sendKeys(u);
		  pass.sendKeys(p);
		  JavascriptExecutor j=(JavascriptExecutor)driver;
		  j.executeScript("arguments[0].click();" , loginbtn);
		  Thread.sleep(2000);
	}
	 public boolean assertion() {
		 return expected.getText().toString().contains("ICTAK - Learner Tracker");
	 }

}
