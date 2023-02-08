package BaseClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class browsersetup {
	
	
	
	public static  WebDriver setup(String browsername) throws MalformedURLException {
		 WebDriver driver=null;
		try {
			if(browsername.equalsIgnoreCase("chrome")) {
//			System.setProperty("webdriver.chrome.driver","C:\\Users\\a846152\\localdownload\\SeleniumGrid\\chromedriver.exe");
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setBrowserName("chrome");
            desiredCapabilities.setPlatform(Platform.LINUX);
            driver = new RemoteWebDriver(new URL("http://35.200.196.1:4444/wd/hub"), desiredCapabilities);


//				WebDriverManager.chromedriver().setup();
//				ChromeOptions options=new ChromeOptions();
//				options.addArguments("disable-notifications");
//				driver= new ChromeDriver(options);
			}else
				if(browsername.equalsIgnoreCase("edge")) {
					WebDriverManager.edgedriver().setup();
					driver= new InternetExplorerDriver();	
				}else
					if(browsername.equalsIgnoreCase("firefox")) {
						WebDriverManager.firefoxdriver().setup();
						driver= new FirefoxDriver();
			
}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
}

//	public static WebDriver setup(String browsername,String URL) throws MalformedURLException {
//		
//		
////		DesiredCapabilities caps = new DesiredCapabilities();
////		caps.setCapability("browserName", "chrome");
////		caps.setCapability("platform", "Windows 10");
////		caps.setCapability("version", "107");
////		caps.setCapability("build", "<your build id>");
////		caps.setCapability("name", "<your test name>");
//
//		
//		WebDriverManager.chromedriver().setup();
//		ChromeOptions browserOptions = new ChromeOptions();
//		browserOptions.setCapability("platformName", "Windows 10");
//		browserOptions.setCapability("browserVersion", "107");
//		Map<String, Object> sauceOptions = new HashMap<>();
//		sauceOptions.put("build", "01");
//		sauceOptions.put("name", "first");
//		browserOptions.setCapability("sauce:options", sauceOptions);
//
//		URL url = new URL("https://oauth-joshiswapnil609-30cae:a7520c99-1011-4c74-89c9-729ad58ea813@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
//		 driver = new RemoteWebDriver(url, browserOptions);
//
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//		driver.manage().deleteAllCookies();
//		driver.get(URL);
//
//		return driver;
//	}
}
