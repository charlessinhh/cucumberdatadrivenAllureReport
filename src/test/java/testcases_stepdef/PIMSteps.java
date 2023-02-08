package testcases_stepdef;

import java.util.List;
import java.util.Map;
import BaseClass.browsersetup;
import PageObjectory.pimpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utility.ExcelReader;
import utility.utility;

public class PIMSteps extends browsersetup{
	pimpage pimp;
	utility ut;
	String excelpath = System.getProperty("user.dir") + "//ExcelData//datasheet.xlsx";
	
	@Given("^User clicks PIM tab$")
	public void user_clicks_PIM_tab() throws Throwable {
		ut= new utility(Hooks.getDriver());
		ut.pause(100);
		pimp= new pimpage(Hooks.getDriver());
		pimp.PIMtab();
	}

	@Then("^User enters the ID \"([^\"]*)\" and rownumber (\\d+)$")
	public void user_enters_the_ID_and_rownumber(String SheetName, int RowNumber) throws Throwable {
		ut.pause(100);
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData(excelpath, SheetName);
		String PSSIdField = testData.get(RowNumber).get("ID");
		pimp.Idtext(PSSIdField);
		ut.pause(100);
	}
}
