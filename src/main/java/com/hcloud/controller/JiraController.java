package com.hcloud.controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.hcloud.service.JiraService;


@RestController
public class JiraController {
	private final RestTemplate restTemplate;
	
	public JiraController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
	
	@Autowired
	private JiraService jiraService;
	
	@RequestMapping(value = "/getJiraSessionId")
	public JSONObject getJiraSessionId(@RequestParam("server") String server,@RequestParam("username") String username,@RequestParam("password") String password) throws ParseException {
		 
		ResponseEntity<String> result=jiraService.getJiraSessionId(server, username, password);
		
	
		    
		    
		    JSONParser parser = new JSONParser(); 
		    JSONObject json = (JSONObject) parser.parse(result.getBody());
//		    JSONObject sessionObject=(JSONObject) json.get("session");
//		    String sessionId= sessionObject.get("value").toString();
//		    System.out.println(sessionId);
//		    if(result.getStatusCode().is2xxSuccessful()) {
//		    	return "index";
//		    }else {
//		    	return "login";
//		    }
		    return json;
			
		
	}
}
