package testRunner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.vimalselvam.cucumber.listener.Reporter;

//import com.relevantcodes.extentreports.ExtentReports;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/features",	
		glue = "stepDef",
		tags = {"@currencyConvCheck"}	,
		plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
		)

public class AcceptanceTest {
	
//	public static ExtentReports extent;
//	
//	@BeforeClass
//	public static void initializeReport(){
//		Date date = new Date();
//		DateFormat df = new SimpleDateFormat("ddMMyyHHmmss");
//		extent = new ExtentReports("target/reports/ExecutionReport_" + df.format(date) + ".html");
//	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Starting Test....");				
	}


@AfterClass
public static void writeExtentReport(){
	Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone").toString());	
}
	
}
