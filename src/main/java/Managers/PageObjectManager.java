package Managers;

import org.openqa.selenium.WebDriver;

import pageObjects.TodosPage;

public class PageObjectManager {
	
	private WebDriver driver;
	private TodosPage todosPO;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public TodosPage getTodosPage() {
		return (todosPO == null) ? todosPO = new TodosPage(driver) : todosPO;
	}

}
