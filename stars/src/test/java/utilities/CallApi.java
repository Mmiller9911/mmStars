package utilities;
import java.util.ArrayList;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.junit.Assert;

import com.google.gson.Gson;

public class CallApi{
	
    private RestTemplate restTemplate = new RestTemplate();
    private HttpHeaders headers = new HttpHeaders();
    private String postURI = "http://localhost:3000/fixture";  
    private String getURI = "http://localhost:3000/fixtures"; 
    public TestContext tp = new TestContext();

	    
	    public void postANewFixture(String id, String home, String away) {        
              
	    	headers.add("Accept", "application/json");
			headers.add("Content-Type", "application/json");
			
	        String jsonBodyBefore = "{\"fixtureId\": \"%s\",\"fixtureStatus\": {\"displayed\": false,\"suspended\": true},\"footballFullState\": {\"homeTeam\": \"%s\",\"awayTeam\": \"%s\",\"finished\": false,\"gameTimeInSeconds\": 2656,\"goals\": [{\"clockTime\": 640,\"confirmed\": true,\"id\": 678606,\"ownGoal\": false,\"penalty\": false,\"period\": \"FIRST_HALF\",\"playerId\": 560617,\"teamId\": \"1\"}],\"period\": \"SECOND_HALF\",\"possibles\": [],\"corners\": [],\"redCards\": [],\"yellowCards\": [],\"startDateTime\": \"2018-03-20T10:49:38.655Z\",\"started\": true,\"teams\": [{\"association\": \"HOME\",\"name\": \"%s\",\"teamId\": \"HOME\"},{\"association\": \"AWAY\",\"name\": \"%s\",\"teamId\": \"AWAY\"}]}}";
	        String jsonBodyAfter = String.format(jsonBodyBefore, id, home, away, home, away);
	        HttpEntity<String> entity = new HttpEntity<String>(jsonBodyAfter, this.headers);         
	        
	        ResponseEntity<String> response; 
	        response = this.restTemplate.postForEntity(postURI, entity, String.class);
	        
	        Assert.assertTrue(response.getBody().contains("Fixture has been added"));
	        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
	        tp.newFixture = Integer.parseInt(id); 
	        
	
	    }
	    
	    public void getAllFixtures() {        
            
	    	headers.add("Accept", "application/json");
			headers.add("Content-Type", "application/json");
			
			ResponseEntity<String> response; 
	        HttpEntity<String> entity = new HttpEntity<String>(this.headers);
	        response = this.restTemplate.getForEntity(getURI, String.class);
               
	        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);	  
	        tp.setFixtureResponse(response.getBody().toString());
	        
	
	    }
	    public void getOneFixture(int number) throws InterruptedException  {        
            
	    	headers.add("Accept", "application/json");
			headers.add("Content-Type", "application/json");
			
	        HttpEntity<String> entity = new HttpEntity<String>(this.headers);
	        ResponseEntity<String> response; 
	        String getOneFixtureURI = postURI + "/" + number;

	        String state = "failure";
	        while(state == "failure"){
	            try{
	            	Thread.sleep(2000);
	    			response = this.restTemplate.getForEntity(getOneFixtureURI,String.class);				       
	    			Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);	  
	    			state = "success";
	    			tp.setNewFixtureResponse(response.getBody().toString());
	                break;
	            }catch(HttpClientErrorException e){
	                System.out.println("HttpClientErrorException detected");
	                e.printStackTrace();
	            }	
	    }
}
	    
	    
	    public void checkFixturesExists(int number) {
	    	Assert.assertEquals(countOccurences(tp.getFixtureResponse(), "fixtureId"), number);
	    	Assert.assertEquals(countOccurences(tp.getFixtureResponse(), "footballFullState"), number);
	    	Assert.assertEquals(countOccurences(tp.getFixtureResponse(), "fixtureStatus"), number);
	    	tp.numberFixtures = number;
	    }
	     
	    public void checkFixtureIdExists() {
	    	Assert.assertEquals(countOccurences(tp.getFixtureResponse(), "fixtureId"), tp.numberFixtures);
	    	
	    }
	    
	    
	    public void deleteAFixtureById(int id) throws Exception {
	    	headers.add("Accept", "application/json");
			headers.add("Content-Type", "application/json");
			
	        HttpEntity<String> entity = new HttpEntity<String>(this.headers);
	        @SuppressWarnings("rawtypes")

	    	String deleteOneFixtureURI = postURI + "/" + id;
	    	
	        String state = "failure";
	        while(state == "failure"){
	            try{
	            	Thread.sleep(2000);
	            	this.restTemplate.delete(deleteOneFixtureURI);  
	    			state = "success";
	                break;
	            }catch(HttpClientErrorException e){
	            	System.out.println("HttpClientErrorException detected");
	                e.printStackTrace();
	            }	
	    	
	        }
	    	
	    }
	    public void checkFixtureNotFound(int id) {
	    	headers.add("Accept", "application/json");
			headers.add("Content-Type", "application/json");
			
	        HttpEntity<String> entity = new HttpEntity<String>(this.headers);
	    	String getOneFixtureURI = postURI + "/" + id;
	    	
	    	Boolean success = false;
	    	
	        try{
	        	this.restTemplate.getForEntity(getOneFixtureURI,String.class);
	        }
	        catch(HttpClientErrorException e){
	           System.out.println("HttpClientErrorException detected");
	           success = true;
	        }
	        
	        Assert.assertTrue(success);
	  
	    }
	    
	    
	    public void checkHomeIdIsCorrect() {
			Gson g = new Gson();
			JSONObject p = g.fromJson(this.tp.getNewFixtureResponse(), JSONObject.class);		
			Map m  = (Map) p.get("footballFullState");			
			ArrayList hometeam = (ArrayList) m.get("teams");			
			Map t = (Map) hometeam.get(0);
			String teamId = (String) t.get("teamId");
			Assert.assertEquals(teamId, "HOME");
	    }
	    static int countOccurences(String str, String word)  
	    { 
	        String a[] = str.split(","); 
	      
	        int count = 0; 
	        for (int i = 0; i < a.length; i++)  
	        { 
	        if (a[i].contains(word))
	            count++; 
	        } 
	      
	        return count; 
	    } 

	    } 
	   