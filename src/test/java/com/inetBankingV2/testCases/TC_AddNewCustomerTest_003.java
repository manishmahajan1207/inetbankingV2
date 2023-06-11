package com.inetBankingV2.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingV2.pageObjects.AddNewCustomerPage;
import com.inetBankingV2.pageObjects.LoginPage;

public class TC_AddNewCustomerTest_003 extends BaseClass {

	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddNewCustomerPage cust = new AddNewCustomerPage(driver);
		
		cust.addNewCustomer();
		
		logger.info("providing customer details....");
		cust.custName("Manish");
		cust.custGender("male");
		cust.custdob("12", "07", "1994");
		Thread.sleep(5000);
		cust.custaddress("Jalgaon");
		cust.custcity("Pune");
		cust.custstate("Maharashtra");
		cust.custpinno("223454");
		
		String Num=randomeNum()+"434365";
		cust.custtelephoneno(Num);
		
		String email=randomestring()+"@gmail.com";
		cust.custemailid(email);
		cust.custpassword("manish@123");
		cust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
	}
	
	
	
	
}
