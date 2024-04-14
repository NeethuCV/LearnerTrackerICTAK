package org.ictaklearnertracker.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EditForm {
	WebDriver driver;

	@FindBy(xpath="//input[@name='learnerid']")
	WebElement id;
	@FindBy(xpath="//input[@name='name']")
	WebElement name;
	@FindBy(xpath="//select[@name='course']")
	WebElement course;
	@FindBy(xpath="//select[@name='project']")
	WebElement project;
	@FindBy(xpath="//select[@name='batch']")
	WebElement batch;
	@FindBy(xpath="//select[@name='cstatus']")
	WebElement cstatus;
	@FindBy(xpath="//button[text()='Submit']")
	WebElement submit;
	/*------------------------------edit----------------------------------------------------------*/
	@FindBy(xpath="//div[@class='table-responsive']//following::button[5]")
	WebElement editbtn;
	@FindBy(xpath="//a[text()='LearnerTracker']")
	WebElement exp;
	/*==-------------------delete----------------------*/
	@FindBy(xpath="//div[@class='table-responsive']//following::button[8]")
	WebElement deletebtn;
	public EditForm(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver2, this);
	}
	
	public void edit() throws InterruptedException {
		editbtn.click();
		Thread.sleep(4000);
	}
	
	
	public void editLearner(String a , String n , int b,int cs) throws InterruptedException  {
		id.clear();
		id.sendKeys(a);
		name.clear();
		name.sendKeys(n);
		Select dp=new Select(batch);
		dp.selectByIndex(b);
		 Thread.sleep(2000);
		Select dn=new Select(cstatus);
		dn.selectByIndex(cs);
		 Thread.sleep(2000);
		 JavascriptExecutor j=(JavascriptExecutor)driver;
		 j.executeScript("arguments[0].click();" , submit);
		 Thread.sleep(4000);
		
	}

	public boolean assertion() {
		return exp.getText().toString().contains("LearnerTracker");
	}
	
	public void delete() throws InterruptedException {
		deletebtn.click();
		Thread.sleep(2000);
	}
}
