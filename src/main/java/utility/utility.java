package utility;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class utility {

    WebDriver driver;


    public utility(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void pause(Integer milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
           System.out.println("Maxmimum Timeout");
        }
    }

}
