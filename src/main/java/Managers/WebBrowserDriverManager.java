package Managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import enums.DriverType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebBrowserDriverManager {

	private static WebBrowserDriverManager driverManager;
	private static WebDriver driver;

	private WebBrowserDriverManager() {
		// TODO Auto-generated constructor stub
	}

	public static WebBrowserDriverManager getInstance() {
		return (driverManager == null) ? driverManager = new WebBrowserDriverManager() : driverManager;
	}

	// Getting driver instance using config properties
	public WebDriver getDriverInstance() {

		String driverType = FileReaderManager.getInstance().getConfigReader().getDriver();

		if (driverType.equalsIgnoreCase("CHROME")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (driverType.equalsIgnoreCase("FIREFOX")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		return driver;
	}

	// Getting driver instance using enum
	public WebDriver getDriverInst(DriverType browserName) {

		switch (browserName) {
			case CHROME: {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			}
			case FIREFOX: {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			}
		}

		return driver;
	}
	
	public WebDriver getDriver() {
		return (driver == null) ? this.getDriverInstance() : driver;
	}

}
