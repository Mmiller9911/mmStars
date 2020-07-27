package utilities;

public class TestContext {

	
	public String fixturesResponse = "";
	public String newFixtureResponse = "";
	public int numberFixtures = 0;
	public int newFixture = 0;
	
	public void setFixtureResponse(String response) {
		this.fixturesResponse = response;
	}
	public String getFixtureResponse() {
		return this.fixturesResponse;
	}
	public void setNewFixtureResponse(String response) {
		this.newFixtureResponse = response;
	}
	public String getNewFixtureResponse() {
		return this.newFixtureResponse;
	}
	public int getNewFixtureId() {
		return this.newFixture;
	}
	
}
