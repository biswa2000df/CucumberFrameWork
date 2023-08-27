package StepDefination;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import PageObject.AddNewCustomer;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;

public class BaseClass {
	
	public static WebDriver driver;
	public LoginPage loginPage;
	public AddNewCustomer addnewCust;
	public SearchCustomerPage serCustPage;
	
	//Generate the random string for email
	public String GenerateEmailId() {
		return (RandomStringUtils.randomAlphabetic(5));
	}

}
