package com.auto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="email") WebElement txtEmail;
	
	@FindBy(name="password") WebElement txtPassword;
	
	@FindBy(xpath="//div[text()='Login']") WebElement btnLogin;
	
	@FindBy(name="password2") WebElement txtPassword2;
	
	public void loginToCRM(String email, String password)
	{
		txtEmail.sendKeys(email);
		
		txtPassword.sendKeys(password);
		
		btnLogin.click();
		
	}
	
	public void loginToCRM2(String email, String password)
	{
		txtEmail.sendKeys(email);
		
		txtPassword2.sendKeys(password);
		
		btnLogin.click();
		
	}
	
}
