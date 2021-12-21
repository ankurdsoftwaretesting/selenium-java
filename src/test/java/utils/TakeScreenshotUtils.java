package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshotUtils {
	
	private WebDriver driver;
	
	public TakeScreenshotUtils(WebDriver driver) {
		this.driver = driver;
	}

	public String getScreenshotPath() throws IOException {
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/Screenshots/image.png";
		FileUtils.copyFile(source, new File(path));
		return path;
	}
	
	public String getScreenshotAsBase64() throws FileNotFoundException, IOException {
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/Screenshots/image.png";
		FileUtils.copyFile(source, new File(path));
		byte[] imageBytes = IOUtils.toByteArray(new FileInputStream(path));
		return Base64.getEncoder().encodeToString(imageBytes);
	}
	
	public File getBase64Screen() {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	}
}
