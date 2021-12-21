package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TodosPage {
	
	WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//footer/p")
	public List<WebElement> footers;
	
	@FindBy(how = How.XPATH, using = "//li//label")
	public List<WebElement> allItems;
	
	@FindBy(how = How.TAG_NAME, using = "input")
	public WebElement todosInputBox;
	
	@FindBy(how = How.CLASS_NAME, using = "todo-count")
	public WebElement footerCount;
	
	@FindBy(how = How.LINK_TEXT, using = "All")
	public WebElement allLink;
	
	@FindBy(how = How.LINK_TEXT, using = "Active")
	public WebElement activeLink;
	
	@FindBy(how = How.LINK_TEXT, using = "Completed")
	public WebElement completedLink;
	
	public TodosPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterTodosItem(String item) {
		todosInputBox.clear();
		todosInputBox.sendKeys(item);
	}

}
