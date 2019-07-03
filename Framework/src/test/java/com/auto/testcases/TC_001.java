package com.auto.testcases;

import org.testng.annotations.Test;

import com.auto.data.CommonData;
import com.auto.pages.LoginPage;

public class TC_001 extends BaseTestCase{
	
	
	@Test
	public void TestCase()
	{
		logger = report.createTest("Login to CRM");
		
		LoginPage loginPage = new LoginPage(driver);
		
		logger.info("Starting Application: Login 12367889");
		
		loginPage.loginToCRM(CommonData.USER1, CommonData.PASSWORD1);
		
		
	}

}
