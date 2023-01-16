package com.inetBankingV2.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBankingV2.pageObjects.LoginPage;
import com.inetBankingV2.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException, IOException {
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(user);
		logger.info("username provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickSubmit();
		Thread.sleep(3000);
		
		if(isAlertPresent()==true) {
			logger.info("Login Failed");
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			captureScreen(driver,"DDloginTest");
			Assert.assertTrue(false);
		}
		else {
			
			logger.info("Login Passed");
			Assert.assertTrue(true);
			lp.clickLogout();
			logger.info("logged out");
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
		}
		
	}
	
	
	//user defined method created to check whether alert is present or not
	public boolean isAlertPresent() {
		
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			
			return false;
		}
		
	}
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException{
		
			String path=System.getProperty("user.dir")+"/src/test/java/com/inetBankingV2/testData/LoginData.xlsx";
			
			int rownum=XLUtils.getRowCount(path, "Sheet1");
			int colcount=XLUtils.getCellCount(path,"Sheet1",1);
			
			String logindata[][]=new String[rownum][colcount];
			
			for(int i=1;i<=rownum;i++)
			{
				for(int j=0;j<colcount;j++)
				{
					logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
				}
					
			}
		return logindata;
		}
		
}
