package org.ictaklearnertracker.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout {

	WebDriver driver;
	@FindBy(xpath="//div[@class='me-5 pe-5 nav-item dropdown']")
	WebElement dropdown;
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logoutbtn;
	
	@FindBy(xpath="//a[text()='LearnerTracker']")
	WebElement exp;
	
	public Logout(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver2, this);
	}

	public void logOut() throws InterruptedException {
		dropdown.click();
		Thread.sleep(2000);
		logoutbtn.click();
		Thread.sleep(2000);
	}
	public boolean assertion() {
		return exp.getText().toString().contains("LearnerTracker");
	}
}
