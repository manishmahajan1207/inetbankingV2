package com.inetBankingV2.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() {
		
		File src = new File("./Configurations/config.properties");
		
		try {
			
			FileInputStream fis=new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public String getApplicationUrl() {
		
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getUsername() {
		String userName = pro.getProperty("username");
		return  userName;
		
	}
	
	public String getPassword() {
		
		String Password = pro.getProperty("password");
		return Password;
	}
	
	public String getChromeBrowser() {
		
		String Chrome = pro.getProperty("chromedriver");
		return Chrome;
	}
	
	public String getEdgeBrowser() {
		
		String Edge = pro.getProperty("edgedriver");
		return Edge;
	}

}
