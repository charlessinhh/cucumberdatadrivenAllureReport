package PageObjectory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pimpage {
WebDriver driver;
	
	
	public pimpage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="menu_pim_viewPimModule")
	private WebElement PIMtab;
	
	@FindBy(id="empsearch_id")
	private WebElement Idtext;
	
	public void PIMtab() {
		PIMtab.click();
	}
	
	public void Idtext(String enterId) {
		Idtext.sendKeys(enterId);
	}
}
