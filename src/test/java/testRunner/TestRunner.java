package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
//		features={".//Features/"},						//this is use to implement all feature file from Features folder.
//		features={".//Features//Login.feature"},
//		features= {".//Features/Login_DDT.feature"},
//		features= {".//Features/Login_DDT_Excel.feature"},
		features= {".//Features/Registration.feature"},
//		features= {".//Features/Login.feature", ".//Features/Registration.feature"},	//this is use to implement files more than one.
//		features="@target/rerun.txt",		//Runs only failure scenarios.
		glue="StepDefinitions",				//to define path of the step definition file
		plugin={"pretty",
				"html:Reports/My_Report.html", 
				"json:Reports/My_Report.json",
				"rerun:target/rerun.txt"	// Mandatory to capture failure scenarios.
				},
		dryRun=false,						// to check all the steps from feature file has method define and implemented
		monochrome=true,						// use to print console output in readable format(must be true)
		tags="@sanity"	//Scenarios tagged with @tagName
//		tags="@sanity and @regression",	//Scenarios tagged with both sanity and regression
//		tags="@sanity or @regression",	//Scenarios tagged with  sanity or regression
//		tags="@sanity and not @regression"	//Scenario tagged with sanity and not with regression //sanity with regression will not execute
		)
public class TestRunner {

}
