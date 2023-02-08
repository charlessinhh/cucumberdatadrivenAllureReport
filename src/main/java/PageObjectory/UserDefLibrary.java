package PageObjectory;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

public class UserDefLibrary {

	WebDriver driver;
	WebDriverWait w;

	public UserDefLibrary(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void sendText(String data, String value) {

		driver.findElement(By.xpath(value)).sendKeys(data);
		}



	public void click(String value) throws InterruptedException  {


			
				Thread.sleep(2000);
				driver.findElement(By.xpath(value)).click();
			
	}

	public void verifyTextEquals(String value, String list1) throws InterruptedException {

		
		String act=null;

			
				w = new WebDriverWait(driver, Duration.ofSeconds(3));
				w.until(ExpectedConditions.presenceOfElementLocated(By.xpath(value)));
				act = driver.findElement(By.xpath(value)).getText();
		    if(act.isEmpty()) {
		    	act=driver.findElement(By.xpath(value)).getAttribute("alt");
		    	System.out.println("Val of the alt attribute="+act);
		    }
		    System.out.println(act);
			Assert.assertEquals(list1, act);
			ExtentCucumberAdapter.addTestStepLog("Expected Message matches with Actual Message");
			ExtentCucumberAdapter.addTestStepLog("Expected Message : " + list1);
			ExtentCucumberAdapter.addTestStepLog("Actual Message : " + act);
			
		
	}

	

}
