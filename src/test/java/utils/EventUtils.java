package utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class EventUtils {
	
	public static void pressReturnKey(WebElement element) {
		element.sendKeys(Keys.RETURN);
	}
	
	public static void enterTextInto(WebElement element, String input) {
		element.clear();
		element.sendKeys(input);
	}
	
	public static void clickOn(WebElement element) {
		element.click();
	}

}
