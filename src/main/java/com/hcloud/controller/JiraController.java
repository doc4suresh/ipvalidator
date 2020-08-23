package com.hcloud.controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.hcloud.service.JiraService;


@RestController
public class JiraController {
	
	
	@Autowired
	private JiraService jiraService;
	
	@RequestMapping(value = "/getJiraSessionId")
	public JSONObject getJiraSessionId(@RequestParam("server") String server,@RequestParam("username") String username,@RequestParam("password") String password) throws ParseException {
		 
		ResponseEntity<String> result=jiraService.getJiraSessionId(server, username, password);
		
		    JSONParser parser = new JSONParser(); 
		    JSONObject json = (JSONObject) parser.parse(result.getBody());
		    return json;
			
		
	}
}
