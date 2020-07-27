@platform

Feature: Trading Platform - fixtures
	In order to trade on fixtures we must be able to perform CRUD operations on them


1. Create and delete a new fixture.
    1. Assert that the fixture no longer exists.

@tc1
  Scenario: Retrieve all fixtures
  	Given I get all fixtures
  	Then I should have "3" fixtures returned in the response
  	And each fixture should have a fixtureId

@tc2
  Scenario: Store a new fixture in the database and then retrieve it as soon as it's available
    Given I get all fixtures
  	And I should have "3" fixtures returned in the response
  	And I add a new fixture with id "4", a home team of "Fulham" and an away team "Brighton" to the trading platform
  	And I wait for the new fixture with id "4" and then retrieve it
  	When I get all fixtures
  	Then I should have "4" fixtures returned in the response
  	And the home team has a teamId of home
  	
@tc3
  Scenario: Create and delete a new fixture
  	Given I add a new fixture with id "9", a home team of "Newcastle" and an away team "Brighton" to the trading platform
  	And I wait for the new fixture with id "9" and then retrieve it 	
  	When I delete the fixture
  	Then the fixture with id "9" is no longer available
  	
  	
  	
  	
  	
  	