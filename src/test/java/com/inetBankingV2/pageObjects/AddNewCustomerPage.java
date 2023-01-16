package com.inetBankingV2.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage {
	
	WebDriver ldriver;
	
	public AddNewCustomerPage(WebDriver rdriver) {
		
		this.ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
		
	}
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'New Customer')]")
	WebElement addNewCustomerLink;
	
	@FindBy(how=How.NAME,using="name")
	WebElement txtCustomerName;
	
	@FindBy(how = How.NAME,using="rad1")
	WebElement rdGender;
	
	@FindBy(how = How.ID_OR_NAME,using="dob")
	WebElement txtDob;
	
	@FindBy(how = How.NAME,using="addr")
	WebElement txtAddress;
	
	@FindBy(how = How.NAME,using="city")
	WebElement txtCity;
	
	@FindBy(how = How.ID_OR_NAME,using="state")
	WebElement txtState;
	
	@FindBy(how = How.NAME,using="pinno")
	WebElement txtPIN;
	
	@FindBy(how = How.NAME,using="telephoneno")
	WebElement txtMobNum;
	
	@FindBy(how = How.NAME,using="emailid")
	WebElement txtEmail;
	
	@FindBy(how = How.NAME,using="password")
	WebElement txtPassword;
	
	@FindBy(how = How.XPATH,using="//tbody/tr[14]/td[2]/input[1]")
	WebElement btnSubmit;
	
	
	public void addNewCustomer() {
		addNewCustomerLink.click();
	}
	
	public void custName(String cname) {
		
		txtCustomerName.sendKeys(cname);
	}
	
	public void custgender(String cgender) {
		rdGender.click();
	}

	public void custdob(String mm,String dd,String yy) {
		txtDob.sendKeys(mm);
		txtDob.sendKeys(dd);
		txtDob.sendKeys(yy);
		
	}

	public void custaddress(String caddress) {
		txtAddress.sendKeys(caddress);
	}

	public void custcity(String ccity) {
		txtCity.sendKeys(ccity);
	}

	public void custstate(String cstate) {
		txtState.sendKeys(cstate);
	}

	public void custpinno(String cpinno) {
		txtPIN.sendKeys(String.valueOf(cpinno));
	}

	public void custtelephoneno(String ctelephoneno) {
		txtMobNum.sendKeys(ctelephoneno);
	}

	public void custemailid(String cemailid) {
		txtEmail.sendKeys(cemailid);
	}

	public void custpassword(String cpassword) {
		txtPassword.sendKeys(cpassword);
	}

	public void custsubmit() {
		btnSubmit.click();
	}
	
	

}
