package dataProvider;

import org.testng.annotations.DataProvider;

public class TestNgDataProvider {

	@DataProvider(name = "getTodosProvider")
	public static Object[][] getTodosItems() {
		return new Object[][] { { "data-provider-1" }, { "data-provider-2" }, { "data-provider-3" } };
	}

}
