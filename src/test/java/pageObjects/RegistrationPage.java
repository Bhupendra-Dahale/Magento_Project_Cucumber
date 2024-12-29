package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
	
	public RegistrationPage(WebDriver driver) {
		super(driver);
	
	}
	
	//Elements
	
	@FindBy(xpath="//input[@id='firstname']")
	WebElement FirstName;
	
	@FindBy(xpath="//input[@id='lastname']")
	WebElement LastName;
	
	@FindBy(xpath="//input[@id='email_address']")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement Password;
	
	@FindBy(xpath="//input[@id='password-confirmation']")
	WebElement ConfPass;
	
	@FindBy(xpath="//button[@class='action submit primary']")
	WebElement CreateAccount;
	
	public void setFirstName(String FN) {
		FirstName.sendKeys(FN);
	}
	public void setLastName(String LN) {
		LastName.sendKeys(LN);
	}
	public void setEmail(String EM) {
		Email.sendKeys(EM);
	}
	public void setPassword(String PS) {
		Password.sendKeys(PS);
		ConfPass.sendKeys(PS);
	}
	public void createAccount() {
		CreateAccount.click();
	}
	
}