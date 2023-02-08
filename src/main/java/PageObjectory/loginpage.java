package PageObjectory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	
	WebDriver driver;
	
	
	public loginpage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="txtUsername")
	private WebElement Username;
	
	@FindBy(id="txtPassword")
	private WebElement Password;
	
	@FindBy(id="btnLogin")
	private WebElement LoginBtn;
	
	public void Username(String strUsername) {
		Username.sendKeys(strUsername);
	}
	
	public void Password(String strPassword) {
		Password.sendKeys(strPassword);
	}
	
	public void LoginBtn() {
		LoginBtn.click();
	}
}
