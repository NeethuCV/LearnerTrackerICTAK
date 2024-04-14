package org.ictaklearnertracker.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TrainerDashboardPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[@href='/tadd']/button")
	WebElement addbtn;
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
	@FindBy(xpath="//button[text()='OK']")
	WebElement ok;
	
	@FindBy(xpath="//a[text()='LearnerTracker']")
	WebElement exp;
	
	/*----------------------------------csv file upload--------------------------------------------------------------*/
	
	@FindBy(xpath="//a[@href='/upload']/button")
	WebElement filebtn;
	
	@FindBy(xpath="//input[@type='file']")
	WebElement choosefile;
	@FindBy(xpath="//button[text()='Submit']")
	WebElement filesubmit;
	@FindBy(xpath="//button[text()='Return to Dashboard']")
	WebElement returnbtn;
	@FindBy(xpath="//button[text()='OK']")
	WebElement okbtn;
	
	
	
	
	public TrainerDashboardPage(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver2, this);
	}

	public void addButton() {
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("arguments[0].click();" , addbtn);

	}
	
	public void addLearner(String a , String n , int c ,int p,int b,int cs)  {
		id.clear();
		id.sendKeys(a);
		name.clear();
		name.sendKeys(n);
		Select dropdown=new Select(course);
		dropdown.selectByIndex(c);
		Select d=new Select(project);
		d.selectByIndex(p);
		Select dp=new Select(batch);
		dp.selectByIndex(b);
		Select dn=new Select(cstatus);
		dn.selectByIndex(cs);
		 JavascriptExecutor j=(JavascriptExecutor)driver;
		 j.executeScript("arguments[0].click();" , submit);
		
	
	
		}
	public void button() throws InterruptedException {
		 ok.click();
		 Thread.sleep(4000);
	}
	
	/*-------------------------------------csv file upload---------------------------------------------*/
	 public void file() {
		 JavascriptExecutor j=(JavascriptExecutor)driver;
		 j.executeScript("arguments[0].click();" , filebtn);
	 }
	
	public void fileUpload(String f) throws InterruptedException  {
		
		choosefile.sendKeys(f);	
		Thread.sleep(3000);
	}
	public void fileSubmit() throws InterruptedException {
		filesubmit.click();
		returnbtn.click();
		okbtn.click();
		Thread.sleep(4000);
	}
	
	public boolean assertion() {
		return exp.getText().toString().contains("LearnerTracker");
	}
	
}
