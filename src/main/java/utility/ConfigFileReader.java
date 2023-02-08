package utility;

public class ConfigFileReader {

	
	public String getReportConfigPath(){
		String reportConfigPath = System.getProperty("C:\\Users\\a846152\\FadexCucumberImplementationProject\\CucumberFrameworkWorkSpace\\Cucumber_DataDrivenFramework2\\config\\extent-config.xml");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}
}
