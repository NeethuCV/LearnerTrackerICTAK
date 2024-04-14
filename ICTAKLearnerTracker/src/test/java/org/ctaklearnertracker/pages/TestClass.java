package org.ctaklearnertracker.pages;

import java.io.File;

import org.ictaklearnertracker.pages.EditForm;
import org.ictaklearnertracker.pages.LoginPage;
import org.ictaklearnertracker.pages.Logout;
import org.ictaklearnertracker.pages.POfficerDashboard;
import org.ictaklearnertracker.pages.PoLoginPage;
import org.ictaklearnertracker.pages.TrainerDashboardPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass  extends BaseClass{
	
	LoginPage lobj;
	TrainerDashboardPage dobj;
	EditForm eobj;
	Logout lgobj;
	PoLoginPage pobj;
	POfficerDashboard pdobj;
	
	@Test(priority=1)
	public void LG_TR_02() throws InterruptedException  {
		 lobj=new LoginPage(driver);
		  Assert.assertEquals(true, lobj.assertion());
		 lobj.loginAction("trainer", "trainer@1");
		 driver.navigate().refresh();
	}
	@Test(priority=2)
	public void LG_TR_03() throws InterruptedException {
		 lobj=new LoginPage(driver);
		  Assert.assertEquals(true, lobj.assertion());
		 lobj.loginAction("trainerr", "trainer@1");
		 driver.navigate().refresh();
	}
	
	
	@Test(priority=3)
	public void LG_TR_04() throws InterruptedException {
		 lobj=new LoginPage(driver);
		  Assert.assertEquals(true, lobj.assertion());
		 lobj.loginAction("trainer","");
		 driver.navigate().refresh();
	}
	@Test(priority=4)
	public void LG_TR_05() throws InterruptedException {
		 lobj=new LoginPage(driver);
		  Assert.assertEquals(true, lobj.assertion());
		 lobj.loginAction("", "trainer@123");
		 driver.navigate().refresh();
	}
	@Test(priority=5)
	public void LG_TR_01() throws InterruptedException {
		 lobj=new LoginPage(driver);
		 Assert.assertEquals(true, lobj.assertion());
		 lobj.loginAction("trainer", "trainer@123");
		 System.out.println("trainer login successfull");
		 Thread.sleep(3000);
		 
	}
	@Test(priority=6)
	public void TC_LR_002() throws InterruptedException {
		dobj=new TrainerDashboardPage(driver);
		dobj.addButton();
		Thread.sleep(3000);
		dobj.addLearner("st_01", "abay", 1,2,4,2);
		driver.navigate().refresh();
	}
	@Test(priority=7)
	public void TC_LR_003() throws InterruptedException {
		dobj=new TrainerDashboardPage(driver);
		dobj.addLearner("st-01", "", 1,2,4,2);
		driver.navigate().refresh();
	}
	@Test(priority=8)
	public void TC_LR_004() throws InterruptedException {
		dobj=new TrainerDashboardPage(driver);
		dobj.addLearner("st-01", "abay", 0,2,4,2);
		driver.navigate().refresh();
	}
	@Test(priority=9)
	public void TC_LR_005() throws InterruptedException {
		dobj=new TrainerDashboardPage(driver);
		dobj.addLearner("st-01", "abay", 1,0,4,2);
		driver.navigate().refresh();
	}
	@Test(priority=10)
	public void TC_LR_006() throws InterruptedException {
		dobj=new TrainerDashboardPage(driver);
		dobj.addLearner("st-01", "abay", 1,2,0,2);
		driver.navigate().refresh();
	}
	@Test(priority=11)
	public void TC_LR_007() throws InterruptedException {
		dobj=new TrainerDashboardPage(driver);
		dobj.addLearner("st-01", "abay", 1,2,4,0);
		driver.navigate().refresh();
	}
	
	@Test(priority=12)
	public void TC_LR_001() throws InterruptedException {
		dobj=new TrainerDashboardPage(driver);
		dobj.addLearner("CSA-16", "key", 6,4,5,2);
		dobj.button();
		System.out.println("successfully added new learner");
		Thread.sleep(4000);
	}
   @Test(priority=13)	
   public void TC_CSV_01() throws InterruptedException {
		dobj=new TrainerDashboardPage(driver);
		Assert.assertEquals(true, dobj.assertion());
		String filepath="E:\\SeleniumExamples\\SampleCSV1.csv";
		File file=new File(filepath);
		if (file.exists()) {
			dobj.file();
			dobj.fileUpload(filepath);
			dobj.fileSubmit();
		} else {
			System.out.println("File not found:" +filepath);
		}
		System.out.println("successfully uploaded csv file");
		Thread.sleep(2000);
	}
	

	@Test(priority=14)
	public void TC_ED_01() throws InterruptedException{
		eobj=new EditForm(driver);
		eobj.edit();
		Assert.assertEquals(true, eobj.assertion());
		eobj.editLearner("89-02", "tina", 5, 1);
		System.out.println("successfully updated learner details");
	}
	@Test(priority=15)
	public void TC_DE_01() throws InterruptedException{
		eobj=new EditForm(driver);
		Assert.assertEquals(true, eobj.assertion());
		eobj.delete();
		System.out.println("successfully deleted selected learner data");
		Thread.sleep(2000);
	}
	@Test(priority=16)
	public void LO_TH_01() throws InterruptedException{
		lgobj=new Logout(driver);
		Assert.assertEquals(true, lgobj.assertion());
		lgobj.logOut();
		System.out.println("trainer successfully logged out");
	}
	
	@Test(priority=17)
	public void LG_PO_02() throws InterruptedException  {
		 pobj=new PoLoginPage(driver);
		 Assert.assertEquals(true, pobj.assertion());
		 pobj.loginAction("Pofficer", "pofficer@123");
		 driver.navigate().refresh();
	}
	@Test(priority=18)
	public void LG_PO_03() throws InterruptedException  {
		 pobj=new PoLoginPage(driver);
		 Assert.assertEquals(true, pobj.assertion());
		 pobj.loginAction("pofficer", "Pofficer@123");
		 driver.navigate().refresh();
	}
	@Test(priority=19)
	public void LG_PO_04() throws InterruptedException  {
		 pobj=new PoLoginPage(driver);
		 Assert.assertEquals(true, pobj.assertion());
		 pobj.loginAction("pofficer", "");
		 driver.navigate().refresh();
	}
	@Test(priority=20)
	public void LG_PO_05() throws InterruptedException  {
		 pobj=new PoLoginPage(driver);
		 Assert.assertEquals(true, pobj.assertion());
		 pobj.loginAction("", "pofficer@123");
		 driver.navigate().refresh();
	}
	@Test(priority=21)
	public void LG_PO_01() throws InterruptedException  {
		 pobj=new PoLoginPage(driver);
		 Assert.assertEquals(true, pobj.assertion());
		 pobj.loginAction("pofficer", "pofficer@123");
		 Thread.sleep(3000);
		 System.out.println("pofficer login successfull");
	}
	@Test(priority=22)
	public void TC_PS_01() throws InterruptedException {
		pdobj=new POfficerDashboard(driver);
		Assert.assertEquals(true, pdobj.assertion());
		pdobj.statusUpdate(2);
		System.out.println("successfully updated placement status");
	}
	
	@Test(priority=23)
	public void LO_PO_01() throws InterruptedException{
		lgobj=new Logout(driver);
		Assert.assertEquals(true, lgobj.assertion());
		lgobj.logOut();
		System.out.println("pofficer successfully logged out");
		
	}

}
