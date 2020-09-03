package com.hcloud.controller;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcloud.model.FirewallRule;
import com.hcloud.service.JiraService;

@Controller
public class HomeController {
		
	@Autowired
	private JiraService jiraService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {

		//return "login";
		
		FirewallRule firewall = new FirewallRule();
		model.addAttribute("firewall", firewall);
		
		return "index";
	}
	
	@RequestMapping(value = "/Request1", method = RequestMethod.GET)
	public String requestModal(Model model) {

		FirewallRule firewall = new FirewallRule();
		model.addAttribute("firewall", firewall);
		return "requestModal";
	}
	
	@RequestMapping(value = "/Home", method = RequestMethod.POST)
	public String home(Model model,@RequestParam("server") String server,@RequestParam("username") String username,@RequestParam("password") String password) throws ParseException {
		
		ResponseEntity<String> result=jiraService.getJiraSessionId(server, username, password);
		if(result.getStatusCode().is2xxSuccessful()) {
			FirewallRule firewall = new FirewallRule();
			model.addAttribute("firewall", firewall);
			return "index";
		}else {
			return "login";
		}		
	}
	
}
