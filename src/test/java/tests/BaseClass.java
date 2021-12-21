package tests;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Managers.ExtentManager;
import Managers.ExtentTestManager;
import Managers.FileReaderManager;
import Managers.PageObjectManager;
import Managers.WebBrowserDriverManager;
import dataProvider.ExcelUtils;
import pageObjects.TodosPage;
import utils.Log;
import utils.TakeScreenshotUtils;

public class BaseClass {
	
	protected WebBrowserDriverManager browserDriverManager;
	protected WebDriver driver;
	protected static ExtentReports extent;
	protected ExtentSparkReporter spark;
	protected ExtentTest newTest;
	protected PageObjectManager poManager;
	protected TodosPage todosPage;
	protected static SoftAssert softAssert;
	protected TakeScreenshotUtils captureScreen;
	
	@BeforeSuite
	public void setupBeforeSuite() {
		Log.info("BaseClass :: BeforeSuite:: setting up extent report");
		extent = ExtentManager.getExtentReport();
		
		Log.info("BaseClass :: BeforeSuite:: Initializing soft assertion");
		softAssert = new SoftAssert();
	}
	
	@AfterSuite
	public void setupAfterSuite() {
		Log.info("BaseClass :: AfterSuite:: flushing extent report");
		ExtentManager.flushExtent(extent);
		
		Log.info("BaseClass :: AfterSuite:: softAssert.assertAll()");
		softAssert.assertAll();
		
		// This is how, we can open the report automatically, using the AWT's Desktop class.
		Log.info("BaseClass :: AfterSuite:: Opening the report automatically using Desktop class of the java.awt");
		try {
			Desktop.getDesktop().browse(new File("test-output/sparkReport.html").toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@BeforeClass
	public void setupBeforeClass() {
		Log.info("BaseClass :: @BeforeClass:: getting driverInstance");
		driver = WebBrowserDriverManager.getInstance().getDriverInstance();
		
		Log.info("BaseClass :: @BeforeClass:: initializing TakeScreenshotUtils");
		captureScreen = new TakeScreenshotUtils(driver);
		
		Log.info("BaseClass :: BeforeClass:: Loading applicationUrl");
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl() + 
				FileReaderManager.getInstance().getConfigReader().getApplicationPath());
		
		Log.info("BaseClass :: BeforeClass:: Initializing PageObjectManager");
		poManager = new PageObjectManager(driver);
		todosPage = poManager.getTodosPage();
		
		Log.info("BaseClass :: BeforeClass:: setting up excel file for test-data");
		try {
			ExcelUtils.setExcelFile(FileReaderManager.getInstance().getConfigReader().getExcelFilePath() + 
					FileReaderManager.getInstance().getConfigReader().getExcelFileName(),
					FileReaderManager.getInstance().getConfigReader().getExcelSheetName());
		}catch(Exception e) {}
	}
	
	@AfterClass
	public void setupAfterClass() {
		Log.info("BaseClass :: @AfterClass:: closing driverInstance");
		driver.close();
		driver.quit();
	}
	
	@BeforeMethod
	public void setupBeforeMethod(Method method) {
		Log.info("BaseClass :: BeforeMethod :: Creating extent test for " + method.getName());
		newTest = ExtentTestManager.createNewTest(extent, method.getName());
		newTest.info("Starting " + method.getName());
	}
	
	@AfterMethod
	public void setupAfterMethod(Method method) {
		Log.info("AfterMethod:: Finished test ::: " + method.getName());
		newTest.info("Executed " + method.getName());
	}
	
	@BeforeTest
	public void beforeTest() {
		Log.info("BaseClass :: beforeTest");
	}

	@AfterTest
	public void afterTest() {
		Log.info("BaseClass :: afterTest");
	}

}
