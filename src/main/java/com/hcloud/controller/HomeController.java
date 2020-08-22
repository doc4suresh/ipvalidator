package com.hcloud.controller;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcloud.model.Firewall;
import com.hcloud.service.FirewallService;
import com.hcloud.service.JiraService;

@Controller
public class HomeController {
	
	@Autowired
	private FirewallService firewallService;
	
	@Autowired
	private JiraService jiraService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {

		return "login";
	}
	
	@RequestMapping(value = "/Home", method = RequestMethod.POST)
	public String home(Model model,@RequestParam("server") String server,@RequestParam("username") String username,@RequestParam("password") String password) throws ParseException {
		
		ResponseEntity<String> result=jiraService.getJiraSessionId(server, username, password);
		if(result.getStatusCode().is2xxSuccessful()) {
			Firewall firewall = new Firewall();
			model.addAttribute("firewall", firewall);
			return "index";
		}else {
			return "login";
		}
		
		
	}
	
	@PostMapping(value = "/addFirewall")
	public String addFirewall(@ModelAttribute("firewall") Firewall firewall, HttpServletRequest request) {
		firewallService.save(firewall);
		
		return "index";
	}
}
