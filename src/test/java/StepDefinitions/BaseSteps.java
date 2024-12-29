package StepDefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;

public class BaseSteps{

	WebDriver driver;
	ResourceBundle rb;
	Logger log;
	
	@Before
	public void setup() throws IOException {
		
		/* Approach-1 with Resource Bundle to read Config.properties file */
		rb=ResourceBundle.getBundle("Config");
		br=rb.getString("browser");
		
		/* Approach-2 with FileInputStream to read Config.properties file */
//		File location=new File(".\\src\\test\\resources\\Config.properties");
//		FileInputStream file=new FileInputStream(location);
//		Properties pr=new Properties();
//		pr.load(file);
//		br=pr.getProperty("browser");
		
		log=LogManager.getLogger(this.getClass());
	}
	
	String br = ResourceBundle.getBundle("Config").getString("browser");
	@Given("User launch the browser")
	public void user_launch_the_browser() {
		log.info("Getting browser Information");

		if(br.equals("chrome")) {
	    	driver=new ChromeDriver();
	    }
	    else if(br.equals("edge")){
	    	driver=new EdgeDriver();
	    }
	    else {
	    	driver=new FirefoxDriver();
	    }
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    log.info("Browser selected successfully");
	}
	
	@Given("Open the Url {string}")
	public void open_the_url(String string) {
		
//		driver.get(string);
//		OR
		driver.get(rb.getString("OpenUrl"));
		
		log.info("URL is opened successfully");
	}
	
	@After
	public void tearDown(Scenario scenario) {
		
		System.out.println("Status of the scenario is --->" + scenario.getStatus());
		
		if(scenario.isFailed()) {
			byte[] screenshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "Image/png", scenario.getName());
		}
		
		driver.quit();
	}
}