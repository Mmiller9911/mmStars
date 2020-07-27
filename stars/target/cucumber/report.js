$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Fixtures.feature");
formatter.feature({
  "line": 3,
  "name": "Trading Platform - fixtures",
  "description": "In order to trade on fixtures we must be able to perform CRUD operations on them\n\n\n1. Create and delete a new fixture.\n  1. Assert that the fixture no longer exists.",
  "id": "trading-platform---fixtures",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@platform"
    }
  ]
});
formatter.scenario({
  "line": 11,
  "name": "Retrieve all fixtures",
  "description": "",
  "id": "trading-platform---fixtures;retrieve-all-fixtures",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 10,
      "name": "@tc1"
    }
  ]
});
formatter.step({
  "line": 12,
  "name": "I get all fixtures",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "I should have \"3\" fixtures returned in the response",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "each fixture should have a fixtureId",
  "keyword": "And "
});
formatter.match({
  "location": "TradePlatformSteps.i_get_all_fixtures()"
});
formatter.result({
  "duration": 425963200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 15
    }
  ],
  "location": "TradePlatformSteps.i_should_have_fixtures_returned_in_the_response(String)"
});
formatter.result({
  "duration": 3244800,
  "status": "passed"
});
formatter.match({
  "location": "TradePlatformSteps.each_fixture_should_have_a_fixtureId()"
});
formatter.result({
  "duration": 100300,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Store a new fixture in the database and then retrieve it as soon as it\u0027s available",
  "description": "",
  "id": "trading-platform---fixtures;store-a-new-fixture-in-the-database-and-then-retrieve-it-as-soon-as-it\u0027s-available",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 16,
      "name": "@tc2"
    }
  ]
});
formatter.step({
  "line": 18,
  "name": "I get all fixtures",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "I should have \"3\" fixtures returned in the response",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "I add a new fixture with id \"4\", a home team of \"Fulham\" and an away team \"Brighton\" to the trading platform",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "I wait for the new fixture with id \"4\" and then retrieve it",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "I get all fixtures",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "I should have \"4\" fixtures returned in the response",
  "keyword": "Then "
});
formatter.step({
  "line": 24,
  "name": "the home team has a teamId of home",
  "keyword": "And "
});
formatter.match({
  "location": "TradePlatformSteps.i_get_all_fixtures()"
});
formatter.result({
  "duration": 7648600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 15
    }
  ],
  "location": "TradePlatformSteps.i_should_have_fixtures_returned_in_the_response(String)"
});
formatter.result({
  "duration": 286200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "4",
      "offset": 29
    },
    {
      "val": "Fulham",
      "offset": 49
    },
    {
      "val": "Brighton",
      "offset": 75
    }
  ],
  "location": "TradePlatformSteps.i_add_a_new_fixture_to_the_trading_platform(String,String,String)"
});
formatter.result({
  "duration": 2010299700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "4",
      "offset": 36
    }
  ],
  "location": "TradePlatformSteps.i_wait_for_the_new_fixture_and_then_retrieve_it(String)"
});
formatter.result({
  "duration": 2008855200,
  "status": "passed"
});
formatter.match({
  "location": "TradePlatformSteps.i_get_all_fixtures()"
});
formatter.result({
  "duration": 4736100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "4",
      "offset": 15
    }
  ],
  "location": "TradePlatformSteps.i_should_have_fixtures_returned_in_the_response(String)"
});
formatter.result({
  "duration": 668400,
  "status": "passed"
});
formatter.match({
  "location": "TradePlatformSteps.the_home_team_has_a_teamId_of_home()"
});
formatter.result({
  "duration": 67016600,
  "status": "passed"
});
formatter.scenario({
  "line": 27,
  "name": "Create and delete a new fixture",
  "description": "",
  "id": "trading-platform---fixtures;create-and-delete-a-new-fixture",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 26,
      "name": "@tc3"
    }
  ]
});
formatter.step({
  "line": 28,
  "name": "I add a new fixture with id \"9\", a home team of \"Newcastle\" and an away team \"Brighton\" to the trading platform",
  "keyword": "Given "
});
formatter.step({
  "line": 29,
  "name": "I wait for the new fixture with id \"9\" and then retrieve it",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "then I delete the fixture",
  "keyword": "When "
});
formatter.step({
  "line": 31,
  "name": "the fixture with id \"9\" is no longer available",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "9",
      "offset": 29
    },
    {
      "val": "Newcastle",
      "offset": 49
    },
    {
      "val": "Brighton",
      "offset": 78
    }
  ],
  "location": "TradePlatformSteps.i_add_a_new_fixture_to_the_trading_platform(String,String,String)"
});
formatter.result({
  "duration": 5010763400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "9",
      "offset": 36
    }
  ],
  "location": "TradePlatformSteps.i_wait_for_the_new_fixture_and_then_retrieve_it(String)"
});
formatter.result({
  "duration": 2004950500,
  "status": "passed"
});
formatter.match({
  "location": "TradePlatformSteps.then_I_delete_the_fixture()"
});
formatter.result({
  "duration": 2004093200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "9",
      "offset": 21
    }
  ],
  "location": "TradePlatformSteps.the_fixture_is_no_longer_available(String)"
});
formatter.result({
  "duration": 18133500,
  "status": "passed"
});
});