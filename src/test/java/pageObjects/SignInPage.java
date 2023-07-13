package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {
	
	public SignInPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "#email")
	WebElement userName;
	
	@FindBy(xpath = "//fieldset[@class='fieldset login']//input[@id='pass']")
	WebElement password;
	
	@FindBy(xpath ="//button[@class='action login primary']")
	WebElement signbtn;
	
	public void username(String email) {
		userName.sendKeys(email);
	}
	
	public void password(String pass) {
		password.sendKeys(pass);
	}

	public void sign_In() {
		signbtn.click();
	}

}
