package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import dataProvider.ExcelUtils;
import dataProvider.TestNgDataProvider;
import listeners.CustomITestListener;
import utils.Log;
import utils.EventUtils;

@Listeners(CustomITestListener.class)
public class Test2 extends BaseClass {

	@Test(groups = { "smoke", "sanity" }, description = "enter todos items from excel file")
	public void test1() {
		Log.info("Test1Class :: test1 Method :: excelData");
		Log.info(" Totoal todos items "+ExcelUtils.getColumnData("Todos_Item_Text"));
		newTest.info("Creating Todos items from excel data sheet ").assignAuthor("AnkurDubey").assignCategory("Integration").assignDevice("Chrome");
		for(String item: ExcelUtils.getColumnData("Todos_Item_Text")) {
			EventUtils.enterTextInto(todosPage.todosInputBox, item);
			EventUtils.pressReturnKey(todosPage.todosInputBox);
		}
//		ExcelUtils.getColumnData("Todos_Item_Text").forEach(newTest::pass);
//		newTest.pass(MarkupHelper.createOrderedList(ExcelUtils.getColumnData("Todos_Item_Text")).getMarkup());
		newTest.pass(MarkupHelper.createUnorderedList(ExcelUtils.getColumnData("Todos_Item_Text")).getMarkup());
		newTest.pass(MarkupHelper.createLabel("Entered data", ExtentColor.BLUE));
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("fname", "ankur");
		map.put("lname", "dubey");
		map.put("country", "singapore");
		
		newTest.info(MarkupHelper.createUnorderedList(map).getMarkup());
	}


	@Test(groups = "regression", dataProvider = "getTodosProvider", dataProviderClass = TestNgDataProvider.class, description = "enter todos items from dataprovide")
	public void test2(String todosItem) {
		Log.info("Test1Class :: test2 Method :: dataProvider");
		newTest.info("Creating Todos items from data provider ").assignCategory("Integration");
		EventUtils.enterTextInto(todosPage.todosInputBox, todosItem);
		EventUtils.pressReturnKey(todosPage.todosInputBox);
		newTest.pass(MarkupHelper.createLabel("Entered data", ExtentColor.BLUE));
	}
	
	@Test(description = "verify completed todos items")
	public void test3() {
		Log.info("Test1Class :: test2 Method :: dataProvider");
		newTest.info("Clicking on completed link ").assignCategory("regression");
		EventUtils.clickOn(todosPage.completedLink);
		softAssert.assertEquals(todosPage.allItems.size(), 0);
		newTest.pass(MarkupHelper.createLabel("Test Passed", ExtentColor.GREEN));
	}
	
	@Test(description = "verify active todos items")
	public void test4() {
		Log.info("Test1Class :: test2 Method :: dataProvider");
		newTest.info("Clicking on active link ").assignCategory("regression");
		EventUtils.clickOn(todosPage.activeLink);
		int itemsCount = todosPage.allItems.size();
//		Assert.assertEquals(itemsCount, 7);
//		Assert.assertEquals(todosPage.footerCount.getText(), itemsCount+" items left");
		softAssert.assertEquals(itemsCount, 7);
		softAssert.assertEquals(todosPage.footerCount.getText(), itemsCount+" items left");
		newTest.pass(MarkupHelper.createLabel("Test Passed", ExtentColor.GREEN));
	}
	
	@Test(description = "verify all todos items")
	public void test5() {
		Log.info("Test1Class :: test2 Method :: dataProvider");
		newTest.info("Clicking on all link ").assignCategory("regression");
		EventUtils.clickOn(todosPage.allLink);
		int itemsCount = todosPage.allItems.size();
		softAssert.assertEquals(itemsCount, 7);
		softAssert.assertEquals(todosPage.footerCount.getText(), itemsCount+" items left");
		
		try {
			newTest.pass("Screen capture", MediaEntityBuilder.
					createScreenCaptureFromBase64String(captureScreen.getScreenshotAsBase64(), "click to view").build());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		newTest.pass(MarkupHelper.createLabel("Test Passed", ExtentColor.GREEN));
	}

}
