package com.hcloud.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.hcloud.model.FirewallRequest;
import com.hcloud.model.FirewallRule;
import com.hcloud.service.FirewallRequestService;
import com.hcloud.service.FirewallRuleService;

@Controller
public class FirewallController {

	@Autowired
	private FirewallRuleService firewallRuleService;
	
	@Autowired
	private FirewallRequestService firewallRequestService;
	
	
	@PostMapping(value = "/addFirewallRule")
	public String addFirewallRule(@ModelAttribute("firewall") FirewallRule firewallRule, HttpServletRequest request) {
		
		
		if(firewallRule.getValidity().equals("Permanent")) {
			firewallRule.setTillDate(null);
		}
		
		
		String apiuri="http://localhost:8081/getRemarks?sourceIP="+firewallRule.getSourceIp()+"&destinationIP="+firewallRule.getDesIp();
		RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(apiuri, String.class);
	    
	    System.out.println("Main service : "+result);
		
	    firewallRule.setRemarks(result);
		
		
		firewallRuleService.save(firewallRule);
		
		return "redirect:/Request";
	
	}
	
	@GetMapping("/deleteFirewallRule")
	public String deleteFirewallRule(@RequestParam("id") Long id) {

		firewallRuleService.deleteById(id);
		return "redirect:/Request";
		
	}
	
	
	@RequestMapping(value = "/Request")
	public String listRequest(Model model) throws IOException {

		 List<FirewallRule> list = firewallRuleService.getPendingFirewallRules();
		 
	     model.addAttribute("FirewallsRules", list);
	     FirewallRule firewall = new FirewallRule();
			model.addAttribute("firewall", firewall);

	     return "requestModal";
	}
	
	@PostMapping(value = "/saveRequest")
	public String saveRequest(Model model) throws IOException {

		FirewallRequest fr = new FirewallRequest();
		fr.setRequestedBy("Admin");//should be retrieved from session
		
	
		FirewallRequest fr2=firewallRequestService.save(fr);
		
		firewallRuleService.updateFirewallRules(fr2.getRequest_id());
		
		return "redirect:/Request";
	}
	
}
