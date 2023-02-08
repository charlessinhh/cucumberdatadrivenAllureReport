package PageObjectory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class adminpage {

WebDriver driver;
	
	
	public adminpage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="menu_admin_viewAdminModule")
	private WebElement Admintab;
	
	@FindBy(id="menu_admin_UserManagement")
	private WebElement UserManagementTab;
	
	@FindBy(id="searchSystemUser_userName")
	private WebElement SearchName;
	
	@FindBy(id="searchBtn")
	private WebElement SearchBtn;
	
	public void Admintab() {
		Admintab.click();
	}
		
	public void UserManagementTab() {
		UserManagementTab.click();
	}
	
	public void SearchName(String searchname) {
			SearchName.sendKeys(searchname);
		
	}
	
	public void SearchBtn() {
		SearchBtn.click();
	}
	
}
