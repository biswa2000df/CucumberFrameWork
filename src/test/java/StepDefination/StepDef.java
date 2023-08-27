package StepDefination;

import java.io.File;
import java.io.IOException;

import org.codehaus.plexus.util.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObject.AddNewCustomer;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

/* Child class of BaseClass*/
public class StepDef extends BaseClass {

	@Before//("@sanity") // this way use the hook condition which scenario is executed
	public void setup() {
		System.out.println("This is the sanity tag"); //// when scenario is sanity then it is executed sanity scenario
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

/*	@Before("@regression") // this is the hook condition which scenario is executed
	public void setup1() {
		System.out.println("This is the regression tag"); // when scenario is regression then it is executed regression
															// scenario
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}*//////aeta kama kariba  hook condition paei
	
	
	

//	@Before(order=2)   order wise to execute haba
//	public void setup1() {
//		
//	}

	@Given("User Lunch Chrome Browser")
	public void user_lunch_chrome_browser() {

		loginPage = new LoginPage(driver);
		addnewCust = new AddNewCustomer(driver);
		serCustPage = new SearchCustomerPage(driver);
	}

	@When("User open url {string}")
	public void user_open_url(String url) {
		driver.get(url);

	}

	@When("User enter Email as {string} and Password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) {
		loginPage.EnterEmail(email);
		loginPage.EnterPassword(password);

	}

	@And("Click on Login")
	public void click_on_login() {

		loginPage.clickOnLoginBtn();
	}

	@Then("Page Title Should Be {string}")
	public void page_title_should_be(String ExceptedResult) {
		String ActualResult = driver.getTitle();

		if (ActualResult.equals(ExceptedResult))
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);

	}

	@When("User click on the logout link")
	public void user_click_on_the_logout_link() {
		loginPage.ClickOnLogoutBtn();

	}

//	@Then("Close the Browser")
//	public void close_the_browser() {
////		driver.close();
////		driver.quit();
////
//	}

	///////////////////////////// add new
	///////////////////////////// Customer/////////////////////////////////////

	@Then("User can view DashBoard")
	public void user_can_view_dash_board() {
		String actualTitle = addnewCust.GetPageTitle();
		String exceptedTitle = "Dashboard / nopCommerce administration";
		if (actualTitle.equals(exceptedTitle))
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);
	}

	@When("User click on Customer Menu")
	public void user_click_on_customer_menu() {
		addnewCust.clickOnCustomer();

	}

	@When("User click on Customers Menu Item")
	public void user_click_on_customers_menu_item() {
		addnewCust.ClickONCustomerItem();
	}

	@When("User click on Add New Button")
	public void user_click_on_add_new_button() {
		addnewCust.ClickOnAddNewCustomer();
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		String actualTitle = addnewCust.GetPageTitle();
		String exceptedTitle = "Add a new customer / nopCommerce administration";
		if (actualTitle.equals(exceptedTitle))
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);

	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
//		addnewCust.EnterEmail("test11@gmail.com");
		addnewCust.EnterEmail(GenerateEmailId() + "@gmail.com");
		addnewCust.EnterPassword("kanha");
		addnewCust.FirstName("kanha");
		addnewCust.LastName("sahoo");
		addnewCust.ChooseGender();
		addnewCust.DOB("04/05/2000");
		addnewCust.Company("Apmosys");
		addnewCust.Comment("Admin comment");
		addnewCust.Vendor(1);

	}

	@When("Click on the save button")
	public void click_on_the_save_button() {
		addnewCust.ClickOnSubmitBtn();
	}

	@Then("User can view the conformation Message {string}")
	public void user_can_view_the_conformation_message(String expectedConformationMessage) {

		String BodyText = driver.findElement(By.tagName("Body")).getText();

		if (BodyText.equals(expectedConformationMessage))
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);
	}

	@When("Enter customer Email as {string}")
	public void enter_customer_email_as(String email) throws InterruptedException {
		serCustPage.EnterEmail(email);
	}

	@When("click on the search Button")
	public void click_on_the_search_button() throws InterruptedException {
		serCustPage.ClickOnSearchButton();
	}

	@Then("User should found Email in the search table")
	public void user_should_found_email_in_the_search_table() {
		String exceptedMail = "arthur_holmes@nopCommerce.com";
		if (serCustPage.CustomerCheckByEmail(exceptedMail) == true) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

	@When("Enter customer FirstName as {string} and LastName as {string}")
	public void enter_customer_first_name_as_and_last_name_as(String FName, String LName) {
		serCustPage.FirstName(FName);
		serCustPage.LastName(LName);
	}

	@Then("User should found Name in the search table")
	public void user_should_found_name_in_the_search_table() {
		String exceptedName = "Virat Kohli";
		if (serCustPage.CustomerCheckByName(exceptedName) == true) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

//	@After
//	public void TearDown(Scenario sc) throws IOException {
//		if (sc.isFailed() == true) {
//			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			String dest = System.getProperty("user.dir") + File.separator + "Screenshot" + File.separator + "Kanha.png";
//			FileUtils.copyFile(src, new File(dest));
//		}
//
////		driver.quit();
//	}
	
	
	@AfterStep
	public void addScreenshot(Scenario scenario){	
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		//attach image file report(data, media type, name of the attachment)
		scenario.attach(screenshot, "image/png", scenario.getName());
		
	}
	
	@After
	public void teardown() {
		driver.quit();
	}

	

//	@After(order=1) using order wise to execute
//	public void TearDown1() {
//		
//	}

	/*
	 * @BeforeStep public void beforeStepmethod() {
	 * System.out.println("This is the before step ..."); }
	 */ // each step execute this method

	/*
	 * @BeforeStep public void afterStepmethod() {
	 * System.out.println("This is the after step ..."); }
	 */
	// each step execute this method

}
