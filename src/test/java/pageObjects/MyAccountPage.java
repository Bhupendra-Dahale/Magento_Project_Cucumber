package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css ="div[class='panel header'] span[class='logged-in']")
	WebElement title;
	
	@FindBy(css = "div[class='panel header'] button[type='button']")
	WebElement dropbtn;
	
	@FindBy(xpath = "//div[@aria-hidden='false']//a[normalize-space()='Sign Out']")
	WebElement signout;
	
	public boolean verifytitle() {
		try 
		{
			return(title.isDisplayed());
		}catch(Exception e) {
			return(false);
		}
	}
	
	public void sign_out() {
		dropbtn.click();
		signout.click();
	}

}
