package steps;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Before;

import com.google.gson.Gson;

import cucumber.api.PendingException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.TestContext;
import utilities.CallApi;


public class TradePlatformSteps{

	CallApi calls = new CallApi();


	@Given("^I get all fixtures$")
	public void i_get_all_fixtures() throws Throwable {
		this.calls.getAllFixtures();
	}

	@Then("^I should have \"([^\"]*)\" fixtures returned in the response$")
	public void i_should_have_fixtures_returned_in_the_response(String number) throws Throwable {
		int i=Integer.parseInt(number); 
		this.calls.checkFixturesExists(i);
	}

	@Then("^each fixture should have a fixtureId$")
	public void each_fixture_should_have_a_fixtureId() throws Throwable {
		this.calls.checkFixtureIdExists();
	}

	@Given("^I add a new fixture with id \"([^\"]*)\", a home team of \"([^\"]*)\" and an away team \"([^\"]*)\" to the trading platform$")
	public void i_add_a_new_fixture_to_the_trading_platform(String id, String home, String away) throws Throwable {
		this.calls.postANewFixture(id, home, away);
	}

	@When("^I wait for the new fixture with id \"([^\"]*)\" and then retrieve it$")
	public void i_wait_for_the_new_fixture_and_then_retrieve_it(String id) throws Throwable {
		int i=Integer.parseInt(id); 
		this.calls.getOneFixture(i);
	
		
		}

	@Then("^the home team has a teamId of home$")
	public void the_home_team_has_a_teamId_of_home() throws Throwable {
		this.calls.checkHomeIdIsCorrect();
	}

	@When("^then I delete the fixture$")
	public void then_I_delete_the_fixture() throws Throwable {
	    int deleteThisFixture = this.calls.tp.getNewFixtureId();
	    this.calls.deleteAFixtureById(deleteThisFixture);
	}

	@Then("^the fixture with id \"([^\"]*)\" is no longer available$")
	public void the_fixture_is_no_longer_available(String id) throws Throwable {
		int i=Integer.parseInt(id); 
		this.calls.checkFixtureNotFound(i);
	}


}
