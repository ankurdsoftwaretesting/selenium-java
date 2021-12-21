package Managers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
	
	public static ExtentTest createNewTest(ExtentReports ext, String testName) {
		return ext.createTest(testName);
	}

}
