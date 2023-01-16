package com.inetBankingV2.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingV2.pageObjects.LoginPage;


public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void loginTest() throws IOException {
		
		logger.info("URL is opened");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("entered username");
		
		lp.setPassword(password);
		logger.info("entered password");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			
			Assert.assertTrue(true);
			logger.info("login test passed");
		}
		
		else {
			logger.info("Login Test Failed");
			captureScreen(driver,"loginTest");
			Assert.assertFalse(true);
			
		}
	}

}
