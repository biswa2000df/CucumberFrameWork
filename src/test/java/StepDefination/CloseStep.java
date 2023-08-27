package StepDefination;

import io.cucumber.java.en.Then;

public class CloseStep extends BaseClass {

	//create the multiple defination file but we can not use the duplicate method in the defination file So this reason to create this class.
	@Then("Close the Browser")
	public void close_the_browser() {
//		driver.close();
//		driver.quit();

	}
	
}
