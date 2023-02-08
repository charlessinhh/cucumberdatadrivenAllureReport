package testcases_stepdef;

import BaseClass.browsersetup;
import PageObjectory.adminpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utility.utility;

public class AdminStep extends browsersetup {
	adminpage ap;
	utility ut;
	
	@Given("^User clicks admin tab$")
	public void user_clicks_admin_tab() throws Throwable {
		ut= new utility(Hooks.getDriver());
		ut.pause(100);
		ap= new adminpage(Hooks.getDriver());
	    ap.Admintab();
	}

	@Then("^User clicks user management tab$")
	public void user_clicks_user_management_tab() throws Throwable {
	    ap.UserManagementTab();
	}

	@Then("^User enters system username \"([^\"]*)\"$")
	public void user_enters_system_username(String searchname) throws Throwable {
		ap.SearchName(searchname);
	}

	@Then("^User clicks search button$")
	public void user_clicks_search_button() throws Throwable {
	    ap.SearchBtn();
	    ut.pause(100);
	}
}
