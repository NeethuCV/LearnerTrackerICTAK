package org.ictaklearnertracker.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class POfficerDashboard {
	
WebDriver driver;
	
	@FindBy(xpath="//div[@class='table-responsive']//following::button[2]")
	WebElement editbtn;
	@FindBy(xpath="//select[@name='pstatus']")
	WebElement pstatus;
	@FindBy(xpath="//button[text()='Submit']")
	WebElement submit;
	
	@FindBy(xpath="//a[text()='LearnerTracker']")
	WebElement exp;
	
	public POfficerDashboard(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver2, this);
	}
	public void statusUpdate(int s) throws InterruptedException {
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("arguments[0].click();" , editbtn);
		Select dp=new Select(pstatus);
		dp.selectByIndex(s);
		submit.click();	
		Thread.sleep(4000);
	}
	public boolean assertion() {
		return exp.getText().toString().contains("LearnerTracker");
	}

}
