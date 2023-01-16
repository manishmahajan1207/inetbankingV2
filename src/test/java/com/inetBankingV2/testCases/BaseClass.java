package com.inetBankingV2.testCases;



import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBankingV2.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readConfig = new ReadConfig();
	
	public String baseURL=readConfig.getApplicationUrl();
	public String username=readConfig.getUsername();
	public String password=readConfig.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	@SuppressWarnings("deprecation")
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
		logger=Logger.getLogger("InetBanking");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver",readConfig.getChromeBrowser());
		driver=new ChromeDriver();
		}
		else if(br.equals("edge")) {
			
			System.setProperty("webdriver.edge.driver",readConfig.getEdgeBrowser());
			driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
	}
	
	
	//method for capturing failed test cases Screenshots
	public void captureScreen(WebDriver driver,String tName) throws IOException
	 {
	 
	   TakesScreenshot ts=(TakesScreenshot)driver;
	   File source=ts.getScreenshotAs(OutputType.FILE); // capture screenshot file
	   File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tName+".png");
	   
	   FileUtils.copyFile(source,target);
	   System.out.println("screenshot captured");
	  
	   
	 }
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}

}
