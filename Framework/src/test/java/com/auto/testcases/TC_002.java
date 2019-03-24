package com.auto.testcases;

import org.testng.annotations.Test;

import com.auto.data.CommonData;
import com.auto.pages.LoginPage;

public class TC_002 extends BaseTestCase{
	
	
	@Test
	public void TestCase()
	{
		logger = report.createTest("Login to CRM2");
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.loginToCRM(CommonData.USER2, CommonData.PASSWORD2);
		
	}

}
