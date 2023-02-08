package runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;




import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features/BPM_SastaSafar_Web.feature", 
glue="testcases_stepdef",
plugin = {"pretty","junit:target/JunitReport/Cucumber.xml",
		"json:target/cucumber-report/cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:target/rerun.txt"},
monochrome =true, //display the console output in a proper readable format
stepNotifications=true
,tags=" @Find_flight_process_ or  @Ways_of_booking_tickets_for_trip_Flight or @Ways_of_booking_tickets_for_trip_Bus or @Ways_of_booking_tickets_for_trip_Packages_ "
//,tags="@Lead_Creation or @Lead_Deletion"
//@Find_flight_process_ or  @Ways_of_booking_tickets_for_trip_Flight or @Ways_of_booking_tickets_for_trip_Bus or @Ways_of_booking_tickets_for_trip_Packages_,tags="@Lead_creation_details_proced_With_mandatory_fields-Save_procedure_for_creating_new_Lead__save"
		
)

public class RunTest {
   
	
}


