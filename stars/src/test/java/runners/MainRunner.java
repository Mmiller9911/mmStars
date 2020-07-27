package runners;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import utilities.CallApi;


@RunWith(Cucumber.class)

@CucumberOptions(
		features= {"src/test/java/features/"},
		glue = {"steps"},
		monochrome = true,
		tags = {},
		plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"}
		)


public class MainRunner{
	
	@AfterClass
	public static void clearAll() throws Exception {
		System.out.println("ending test run");
		CallApi calls = new CallApi();
		calls.deleteAFixtureById(4);
	}
}
