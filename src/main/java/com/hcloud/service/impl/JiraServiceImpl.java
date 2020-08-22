package com.hcloud.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.parser.ParseException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.hcloud.service.JiraService;

@Service
public class JiraServiceImpl implements JiraService{

private final RestTemplate restTemplate;
	
	public JiraServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
	
	@Override
	public ResponseEntity<String> getJiraSessionId(String server, String username, String password) throws ParseException {
		String url = "http://"+server+"/rest/auth/1/session";

	    // create headers
	    HttpHeaders headers = new HttpHeaders();
	    // set `content-type` header
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    // set `accept` header
	    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

	    // create a map for post parameters
	    Map<String, Object> map = new HashMap<>();
	    map.put("username", username);
	    map.put("password", password);
	    
	    // build the request
	    HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

	    ResponseEntity<String> result=this.restTemplate.postForEntity(url,entity, String.class);
	    
		return result;
	}

	
	
}
