package StepDefinitions;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;
//import java.io.File;
//import java.io.FileInputStream;
//import java.util.Properties;

import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.RegistrationPage;
import pageObjects.SignInPage;
import utilities.DataReader;

public class StepDef {
	WebDriver driver;
	Logger log;
	
	HomePage hp;
	SignInPage signIn;
	MyAccountPage myacc;
	RegistrationPage regpage;
	
	List<HashMap<String, String>> datamap;

	@When("User click on sign-in")
	public void user_click_on_sign_in() {
		
	    hp=new HomePage(driver);
	    
	    hp.signIn();
	    
	    log.info("Successfully clicked on SignIn button on Home Page");
	}

	@When("User provide Email as {string} and Password as {string}")
	public void user_provide_email_as_and_password_as(String string, String string2) {
		
	   signIn=new SignInPage(driver);
	   
	   signIn.username(string);
	   signIn.password(string2);
	   
	   log.info("Credentials provided successfully");
	}

	@When("click on Login button")
	public void click_on_login_button() {
		
		signIn.sign_In();
		
		log.info("Successfully cliked on Sign-In");
	}

	@Then("MyAccount page should display")
	public void my_account_page_should_display() {
		log.info("Successfully SignIn to MyAccount page");
		myacc=new MyAccountPage(driver);
		
		boolean targettitle=myacc.verifytitle();
		
		if(targettitle) {
			Assert.assertTrue(true);
			log.info("Title is verfied");
		}else {
			Assert.assertTrue(false);
			log.error("Login failed");
		}
	}

	@Then("User should logout successfully")
	public void user_should_logout_successfully() {
		
	    myacc.sign_out();
	    
	    log.info("Sign-out successfully");
	}

//  *************** Data Driver Step ****************
	
	@Then("Check user navigates to the MyAccount page by passing Email and Password with Excel ros {string}")
	public void check_user_navigates_to_the_my_account_page_by_passing_email_and_password_with_excel_ros(String rows) {
		
		datamap=DataReader.data(System.getProperty("user.dir")+"\\TestData\\UserData.xlsx", "User_Info");	//data is a static method hence we can directly use like this ClassName.MethodName();
		
		int index=Integer.parseInt(rows)-1;
	
		String email=datamap.get(index).get("User_ID");
		String pwd=datamap.get(index).get("Password");
		String status=datamap.get(index).get("Status");
		
		signIn=new SignInPage(driver);
		signIn.username(email);
		signIn.password(pwd);
		signIn.sign_In();
		
		try {
			myacc=new MyAccountPage(driver);
			boolean title=myacc.verifytitle();
			
			if(status.equals("Valid")) {
				if(title==true) {
					myacc.sign_out();
					Assert.assertTrue(true);
					log.info("Title is matched successfully");
				}else{
					Assert.assertTrue(false);
				}
			}
			
			if(status.equals("Invalid")) {
				if(title==true) {
					myacc.sign_out();
					Assert.assertTrue(false);
				}else {
					log.info("Credential is invalid");
					Assert.assertTrue(true);
				}
			}
			
		}catch(Exception e){
			Assert.assertTrue(false);
		}
	}
	
	// *************  Create an Account  *************** //
	
	@When("User click on Create an Account")
	public void User_click_on_Create_an_Account() {
		
		hp.createAnAccount();
		
		log.info("Successfuly clicked on create an account");
	}
	
	@Then("Fill the following personal details")
	public void Then_Fill_the_following_personal_details(DataTable datatable) {
		
		regpage =new RegistrationPage(driver);
		Map<String, String> dataMap = datatable.asMap(String.class,String.class);
		
		regpage.setFirstName(dataMap.get("FirstName"));
		regpage.setLastName(dataMap.get("LastName"));
		regpage.setEmail(dataMap.get("Email"));
		regpage.setPassword(dataMap.get("Password"));
		regpage.createAccount();
		}
	
	}
