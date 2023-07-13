package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	// Elements
		@FindBy(id = "firstname")
		WebElement txtFirstname;

		@FindBy(id = "lastname")
		WebElement txtLasttname;

		@FindBy(id = "email_address")
		WebElement txtEmail;

		@FindBy(id = "telephone")
		WebElement txtTelephone;

		@FindBy(id = "password")
		WebElement txtPassword;

		@FindBy(id = "password-confirmation")
		WebElement txtConfirmPassword;

		@FindBy(name = "agree")
		WebElement chkdPolicy;

		@FindBy(css = "button[title='Create an Account'] span")
		WebElement btnContinue;

		@FindBy(css = "div[data-bind='html: $parent.prepareMessageForHtml(message.text)']")
		WebElement msgConfirmation;
		
		@FindBy(id= "is_subscribed")
		WebElement radio;

		public void setFirstName(String fname) {
			txtFirstname.sendKeys(fname);

		}

		public void setLastName(String lname) {
			txtLasttname.sendKeys(lname);

		}

		public void setEmail(String email) {
			txtEmail.sendKeys(email);

		}

		public void setTelephone(String tel) {
			txtTelephone.sendKeys(tel);

		}

		public void setPassword(String pwd) {
			txtPassword.sendKeys(pwd);

		}

		public void setConfirmPassword(String pwd) {
			txtConfirmPassword.sendKeys(pwd);

		}

		public void setPrivacyPolicy() {
			chkdPolicy.click();

		}
		
		public void newsLetter() {
			radio.click();
		}

		public void clickContinue() {
			//sol1 
			btnContinue.click();
			
			//sol2 
			//btnContinue.submit();
			
			//sol3
			//Actions act=new Actions(driver);
			//act.moveToElement(btnContinue).click().perform();
						
			//sol4
			//JavascriptExecutor js=(JavascriptExecutor)driver;
			//js.executeScript("arguments[0].click();", btnContinue);
			
			//Sol 5
			//btnContinue.sendKeys(Keys.RETURN);
			
			//Sol6  
			//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
			//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
			
		}

		public String getConfirmationMsg() {
			try {
				return (msgConfirmation.getText());
			} catch (Exception e) {
				return (e.getMessage());

			}

		}
}