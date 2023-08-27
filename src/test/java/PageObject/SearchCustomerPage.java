package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {

	WebDriver rdriver;

	public SearchCustomerPage(WebDriver ldriver) {
		rdriver = ldriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//input[@id=\"SearchEmail\"]")
	WebElement EnterEmail;
	
	@FindBy(id="SearchFirstName")
	WebElement FirstName;
	
	@FindBy(id="SearchLastName")
	WebElement LastName;

	@FindBy(xpath = "//button[@id=\"search-customers\"]")
	WebElement ClickOnSearchButton;

	@FindBy(xpath = "//*[@id=\"customers-grid\"]/tbody/tr")
	List<WebElement> rowList;

	public void EnterEmail(String email) throws InterruptedException {
		EnterEmail.clear();
		EnterEmail.sendKeys(email);
	}

	public void ClickOnSearchButton() throws InterruptedException {
		ClickOnSearchButton.click();
		Thread.sleep(5000);
	}
	
	public void FirstName(String FName) {
		FirstName.sendKeys(FName);
	}
	
	public void LastName(String LName) {
		LastName.sendKeys(LName);
	}
	/////customer check by name///////////
	public boolean CustomerCheckByName(String name) {
		boolean found = false;

		int rowSize = rowList.size();

		for (int i = 1; i <= rowSize; i++) {
			WebElement Element = rdriver.findElement(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr[" + i + "]/td[3]"));
			String actualName = Element.getText();
			if (actualName.equals(name)) {
				found = true;
				break;
			}
		}
		return found;
	}
	
	
//////Customer check by email////////
	public boolean CustomerCheckByEmail(String Email) {
		boolean found = false;

		int rowSize = rowList.size();

		for (int i = 1; i <= rowSize; i++) {
			WebElement Element = rdriver.findElement(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr[" + i + "]/td[2]"));
			String actualEmail = Element.getText();
			if (actualEmail.equals(Email)) {
				found = true;
				break;
			}
		}
		return found;
	}

}
