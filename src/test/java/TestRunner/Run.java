package TestRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/*
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)*///convert junit to testng to comment this block of code 
@CucumberOptions(//features = ".//Features/LoginFeature.feature", // Single feature file run
		features=".//Features/",   // to execute the multiple feature file 
//		features = { ".//Features/Customer.feature", ".//Features/LoginFeature.feature" }, /// To execute specific
		/// feature file and
		/// sequence wise then use
		/// the this format
		glue = "StepDefination", dryRun = false, monochrome = true, tags = "@regression", // senario under sanity tag will
																						// bwe executed
//		tags="@regression",    //senario under regression tag will bwe executed
//		tags="@sanity or @regression", //will run senario tag with sanity and regression
//		tags="@sanity and @regression",  //will run scenario which is tag with sanity al well as regression
//		tags="@sanity and not @regression",   //will run scenario which is sanity but not regression
//		plugin = {"pretty","html:target/cucumber_reports/reports1.html"} this is generate the html report for the normal way
		plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" } // this is the extent report
																							// of the proper format way

)

//plugin = {"pretty","html:target/cucumber_reports/reports1.html"}------ to generate the html formate

//plugin = {"pretty","json:target/cucumber_reports/reports_json.json"} ==== to generate report the json format

//plugin = {"pretty","junit:target/cucumber_reports/reports_xml.xml"} === to generate the report xml format

public class Run extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
	/* This class will Be Empty */
}
