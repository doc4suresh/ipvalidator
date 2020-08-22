package com.hcloud.service;

import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;

public interface JiraService {

	ResponseEntity<String> getJiraSessionId(String server,String username, String password) throws ParseException;
}
