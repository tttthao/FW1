package com.auto.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.auto.data.CommonData;

public class Helper {

	//Screenshot, alerts, frames, windows, Sync issue, javascript executor
	
	public static String captureScreenshot(WebDriver driver)
	{
		String screenshotPath = CommonData.SCREENSHOTS_FOLDER + "/Screenshot_"+ Helper.getCurrentDateTime() +".png";
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		System.out.println("Screenshot captured!!!");
		
		try {
			FileHandler.copy(src,new File(screenshotPath));
		} catch (IOException e) {
			
			System.out.println("Unable to capture screenshot " + e.getMessage());
		}
		
		return screenshotPath;
	}
	
	public static String getCurrentDateTime(){

		return new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss").format(new Date());

	}
}
