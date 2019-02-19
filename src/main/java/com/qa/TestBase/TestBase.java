package com.qa.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	
	public Properties prop;
	
	public TestBase() {
		//"C:\\Storage\\FreeCrm\\com.qa.restassuredApiTesting\\src\\main\\java\\come\\qa\\propertyFile\\config.properties"
		//FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"/com.qa.restassuredApiTesting/src/main/java/come/qa/propertyFile/config.properties"
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream("C:\\Storage\\FreeCrm\\com.qa.restassuredApiTesting\\src\\main\\java\\come\\qa\\propertyFile\\"+"config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("*************file not found*********");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
