package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// Elements
	@FindBy(xpath = "//div[@class='panel header']//a[normalize-space()='Create an Account']")
	WebElement createAcc;
	
	@FindBy(css = "div[class='panel header'] li[data-label='or'] a")
	WebElement signIn;


	// Action Methods
	public void createAnAccount() {
		createAcc.click();
	}
	
	public void signIn() {
		signIn.click();
	}
	
}
