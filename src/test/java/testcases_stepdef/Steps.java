package testcases_stepdef;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.runner.RunWith;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.util.Assert;

import BaseClass.browsersetup;
import PageObjectory.TrackScenarioError;
import PageObjectory.UserDefLibrary;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

import utility.ReadExcelFile;
import utility.utility;
@RunWith(Cucumber.class)
public class Steps extends browsersetup {

	public  String value;
	public  String value2;
	public static String featureName;
	static Scenario scenario;
	public int sr=0;
	Hooks h=new Hooks();
	UserDefLibrary ap=new UserDefLibrary(h.getDriver());
	utility ut=new utility(h.getDriver());
	ReadExcelFile ref=new ReadExcelFile();
//	public String excelpath = System.getProperty("user.dir") + "//ExcelData//SalesforceDataSheet.xlsx";
	public String excelpath;
	public static String step;

	
	
	@Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
	}
	
	  @Given("^User refer the \"([^\"]*)\"$")
	    public void user_refer_the_something(String filename) throws Throwable {
		
			try {
				h.reportStatus(getFeatureName(),scenario.getName(),"Running");
				  excelpath = System.getProperty("user.dir") + "//ExcelData//"+filename;
				  ExtentCucumberAdapter.addTestStepLog("DataSheet : " + filename);
			} catch (Exception e) {
				e.printStackTrace();
				step="User refer the" +filename;
			   TrackScenarioError.insertErrorIntoExcel(getFeatureName(),scenario.getName(),step,e.getMessage());				
			   assertEquals("FAILED", scenario.getStatus());
			}
		
	  }

	

	  
	  
	  
	//User enters text "data" in text field "fieldName"
	  @When("^User enters text in text field \"([^\"]*)\" from given sheet \"([^\"]*)\"$")
	    public void user_enters_text_in_text_field_something_from_given_sheet_something(String strArg1, String sheetname) throws Throwable {

		
			try {
				h.reportStatus(getFeatureName(),scenario.getName(),"Running");
				ut.pause(1000);
				value=null;
				value2=null;
				System.out.println("loc and testdata "+value +"  "+value2);
				value=ref.readObj(excelpath, strArg1,"TestData");
				value2=ref.readObj(excelpath, strArg1,"ObjectLocators");
				ExtentCucumberAdapter.addTestStepLog("Field Name : " + strArg1);
				ExtentCucumberAdapter.addTestStepLog("Test Data : " + value);
				ap.sendText(value,value2);
				System.out.println("loc and testdata "+value +"  "+value2);
				ut.pause(1000);
			}catch (Exception e) {
				e.printStackTrace();
				step="User enters text in text field"+strArg1 +"from given sheet" +sheetname;
				TrackScenarioError.insertErrorIntoExcel(getFeatureName(),scenario.getName(),step,e.getMessage());				
				 assertEquals("FAILED", scenario.getStatus());

			}
		
    }

    @And("^User click on the \"([^\"]*)\"$")
    public void user_click_on_the_something(String strArg1) throws Throwable {
    	
    		try {
				h.reportStatus(getFeatureName(),scenario.getName(),"Running");
				ut.pause(2000);
				value=ref.readObj(excelpath, strArg1,"ObjectLocators");
				ExtentCucumberAdapter.addTestStepLog("Field Name :"+strArg1);
				ap.click(value);
				ut.pause(2000);
			} catch (Exception e) {
				e.printStackTrace();
				step="User click on the "+strArg1;
				TrackScenarioError.insertErrorIntoExcel(getFeatureName(),scenario.getName(),step,e.getMessage());				
				assertEquals("FAILED", scenario.getStatus());

			}

    }
   

    @And("^Verify the \"([^\"]*)\" with \"([^\"]*)\" from given sheet \"([^\"]*)\"$")
    public void verify_the_something_with_something(String strArg1,String list1,String stragr2) throws Throwable {
    		try {
				h.reportStatus(getFeatureName(),scenario.getName(),"Running");
				ut.pause(1000);
				value=ref.readObj(excelpath, strArg1,"ObjectLocators");
				String Exp_msgs = ref.readObj(excelpath,list1,"TestData");
				ap.verifyTextEquals(value,Exp_msgs);
				ut.pause(1000);
			} catch (Exception e) {				
				e.printStackTrace();
				step="Verify "+strArg1+" with "+list1+" from given sheet "+stragr2;
				TrackScenarioError.insertErrorIntoExcel(getFeatureName(),scenario.getName(),step,e.getMessage());				
				assertEquals("FAILED", scenario.getStatus());

			}
        
    }
    @When("^User enters \"([^\"]*)\" into the \"([^\"]*)\"$")
    public void user_enters_something_into_the_the_something(String data, String obj) throws Throwable {
    
    		
    		try {
				h.reportStatus(getFeatureName(),scenario.getName(),"Running");
				ut.pause(1000);
				value=ref.readObj(excelpath, obj,"ObjectLocators");
				value2=ref.readObj(excelpath, data,"TestData");
				ExtentCucumberAdapter.addTestStepLog("Field Name : " + obj);
				ExtentCucumberAdapter.addTestStepLog("Test Data : " + data);
				ap.sendText(value2, value);
			} catch (Exception e) {
				e.printStackTrace();
				step="User enters "+data+" into the "+obj;
				TrackScenarioError.insertErrorIntoExcel(getFeatureName(),scenario.getName(),step,e.getMessage());				
				assertEquals("FAILED", scenario.getStatus());

			}
    }
    public static String getFeatureName()throws NullPointerException {
        
    	
		try {
			String[] tab = scenario.getId().split("/");
			int rawFeatureNameLength = tab.length;
			String featureFileName = tab[rawFeatureNameLength - 1].split(":")[0];
			featureName = featureFileName.split("[.]")[0];
		} catch (NullPointerException e) {
			e.printStackTrace(); 
		}
         return featureName;

    }

	
	
	
}
