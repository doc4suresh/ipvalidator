package com.hcloud.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.hcloud.model.Firewall;
import com.hcloud.model.FirewallRule;
import com.hcloud.service.FirewallRuleService;

@Controller
public class FirewallController {

	@Autowired
	private FirewallRuleService firewallRuleService;
	
	@PostMapping(value = "/addFirewallRule")
	public String addFirewallRule(@ModelAttribute("firewall") FirewallRule firewallRule, HttpServletRequest request) {
		firewallRuleService.save(firewallRule);
		
		return "redirect:/Request";
	
	}
	
	@RequestMapping(value = "/Request")
	public String listEmployee(Model model) throws IOException {

		 List<FirewallRule> list = firewallRuleService.getAllFirewallRules();
		 
	     model.addAttribute("FirewallsRules", list);
	     Firewall firewall = new Firewall();
			model.addAttribute("firewall", firewall);

	     return "requestModal";
	}
	
}
