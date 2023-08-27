package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomer {

	WebDriver rdriver;
	
	public AddNewCustomer(WebDriver ldriver) {
		rdriver=ldriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(xpath="//a[@href=\"#\"]//p[contains(text(),'Customers')]")
	WebElement Customer;
	
	@FindBy(xpath="//a[@href=\"/Admin/Customer/List\"]//p[contains(text(),'Customers')]")
	WebElement CustomerItem;
	
	@FindBy(xpath="//a[@class=\"btn btn-primary\"]")
	WebElement AddNewCustomer;
	
	@FindBy(xpath="//input[@id=\"Email\"]")
	WebElement EnterEmail;
	
	@FindBy(xpath="//input[@id=\"Password\"]")
	WebElement EnterPassword;
	
	@FindBy(xpath="//input[@id=\"FirstName\"]")
	WebElement FirstName;
	
	@FindBy(xpath="//input[@id=\"LastName\"]")
	WebElement LastName;
	
	@FindBy(xpath="//input[@id=\"Gender_Male\"]")
	WebElement Gender;
	
	@FindBy(xpath="//input[@id=\"DateOfBirth\"]")
	WebElement DOB;
	
	@FindBy(xpath="//input[@id=\"Company\"]")
	WebElement Company;
	
	@FindBy(xpath="//input[@id=\"IsTaxExempt\"]")
	WebElement taxEmpty;
	
	@FindBy(xpath="(//div[@class=\"input-group\"]//div[@class=\"k-multiselect-wrap k-floatwrap\" and @role=\"listbox\"])[2]")
	WebElement NewsLetter;
	
	@FindBy(xpath="//select[@id=\"VendorId\"]")
	WebElement Vendor;
	
	@FindBy(xpath="//textarea[@id=\"AdminComment\"]")
	WebElement Comment;
	
	@FindBy(xpath="//button[@type=\"submit\"and@name=\"save\"]")
	WebElement ClickOnSubmitBtn;
	
	
	public String  GetPageTitle() {
		return rdriver.getTitle();
	}
	
	public void clickOnCustomer() {
		Customer.click();
	}
	
	public void ClickONCustomerItem() {
		CustomerItem.click();
	}
	
	public void ClickOnAddNewCustomer() {
		AddNewCustomer.click();
	}
	
	public void EnterEmail(String email) {
		EnterEmail.sendKeys(email);
	}
	
	public void EnterPassword(String password) {
		EnterPassword.sendKeys(password);
	}
	
	public void FirstName(String fname) {
		FirstName.sendKeys(fname);
	}
	
	public void LastName(String lname) {
		LastName.sendKeys(lname);
	}
	
	public void ChooseGender() {
		Gender.click();
	}
	
	public void DOB(String dob) {
		DOB.sendKeys(dob);
	}
	
	public void Company(String company) {
		Company.sendKeys(company);
	}
	
	public void taxEmpty() {
		taxEmpty.click();
	}
	
	public void NewsLetter(String newsLetter) {
		NewsLetter.sendKeys(newsLetter);
	}
	
	public void Vendor(int index) {
		Select s=new Select(Vendor);
		s.selectByIndex(index);
	}
	
	public void Comment(String comment) {
		Comment.sendKeys(comment);
	}
	
	public void ClickOnSubmitBtn() {
		ClickOnSubmitBtn.click();
	}
	
	
	
	
	
}
