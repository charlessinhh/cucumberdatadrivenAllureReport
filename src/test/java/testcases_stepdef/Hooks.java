package testcases_stepdef;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Properties;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import BaseClass.browsersetup;
import PageObjectory.loginpage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestCase;
import io.cucumber.plugin.event.TestStep;
import utility.utility;


public class Hooks extends browsersetup {
	public File f;
	public FileWriter writer;
	public String path;
	loginpage lg;
	utility ut;
	static String configfilepath = System.getProperty("user.dir") + "//config//file.properties";
	static Properties prop;
	static FileInputStream fileInput;
	public int currentStepIndex;
	public static String step;
	

	protected static ThreadLocal<WebDriver>threadlocaldriver=new ThreadLocal<>();

	public static void Configuration() {
		try {
			fileInput = new FileInputStream(configfilepath);
		} catch (FileNotFoundException e) {
			
			System.out.println("File Not Found at path: "+configfilepath);
			System.exit(0);
		}
		prop = new Properties();
		try {
			prop.load(fileInput);
		} catch (IOException e) {
		
			System.out.println("Problem while reading Config File");
			System.exit(0);
			
		}
	}

	public static WebDriver getDriver() {
		return threadlocaldriver.get();
	}
	@Before
	public void setUp() throws InterruptedException, IOException {
		System.out.println("Open the browser");
		Configuration();
		
		  WebDriver driver = browsersetup.setup(prop.getProperty("Browsername"));
          threadlocaldriver.set(driver);
          getDriver().get(prop.getProperty("Url"));
		lg = new loginpage(getDriver());
		ut = new utility(getDriver());
		ut.pause(100);

	}
	
	@After
	public void tearDown(Scenario scenario) throws NullPointerException, IOException  {
		
		        
				if (scenario.isFailed()) {
					final byte[] screenshot =

							((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
					scenario.attach(screenshot, "image/png", "report");
					Allure.addAttachment("failure test", new ByteArrayInputStream(screenshot));
					reportStatus(Steps.getFeatureName(), scenario.getName(), "Fail");
					ut.pause(10000);

				} else {
					reportStatus(Steps.getFeatureName(), scenario.getName(), "Pass");
					ut.pause(10000);

				}
//				if(getDriver()==null) {
//					 driver.quit();
//					 reportStatus(Steps.getFeatureName(), scenario.getName(), "Finished");
//				}
			  getDriver().quit();
			  reportStatus(Steps.getFeatureName(), scenario.getName(), "Finished");
	}
	public void reportStatus(String feature,String scenario,String status) throws IOException  {
       
		
		
		try {
			
			//dynamic path
			 String path1="C:\\Work\\Cucumber_DataDrivenFramework_Exceptions\\Cucumber_DataDrivenFramework_Exceptions\\src\\test\\Resources\\CurrentStatus.html";
			path = System.getProperty("user.dir") + "//src//test//Resources//CurrentStatus.html";
			
			 f=new File(path);
			writer= new FileWriter(f);
			writer.write(
			        "<style type=\"text/css\">"+
			        ".tg  {border-collapse:collapse;border-spacing:0;}"+
			        ".tg td{border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;"+
			         " overflow:hidden;padding:10px 5px;word-break:normal;}" +
			        " .tg th{border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px; "+
			          "font-weight:normal;overflow:hidden;padding:10px 5px;word-break:normal;}"+
			        ".tg .tg-0pky{border-color:inherit;text-align:left;vertical-align:top}"+
			        ".tg .tg-0lax{text-align:left;vertical-align:top}"+
			        ".tr #header {font-weight: 900;}"+
			        "</style>"+

			        //table 
			        "<table id=\"tbl\" class=\"tg\" style=\"width:100%\">"+

			        "<thead>"+
			        //refresh page every 1sec
			        " <script type=\"text/javascript\">"+
			        "window.onload = setupRefresh;"+

			        "function setupRefresh() {"+ 
			            "setTimeout(\"refreshPage();\", 1000); "+ // milliseconds
			        "}"+
			        "function refreshPage() { "+
			         "window.location = location.href; " +
//                    "document.getElementById('status').innerHTML ="+ status +"; " +
			        "}"+
			        "</script>" +


			          "<tr id=\"header\">" +
			            "<th class=\"tg-0pky\">Feature Name</th>"+
			            "<th class=\"tg-0lax\">Scenario Name</th>"+
			            "<th class=\"tg-0lax\">Status</th>"+

			          "</tr>"+

//                "<element onload=\"addScenario();\" > "+

 

			        "</thead>"+


			        "<tbody>"+
			          "<tr>"+
			            "<td class=\"tg-0lax\">"+feature+"</td>"+
			            "<td class=\"tg-0lax\">"+scenario+"</td>"+
			            "<td class=\"tg-0lax\" id=\"status\"> "+status+" </td> "+
			          "</tr>"+


 

			        "</tbody>"+
			        "</table>" 

			      
			        );
		} catch (Exception n) {
			
            
		}
		finally {
        writer.close();
		}
    }
}
