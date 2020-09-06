package com.hcloud.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hcloud.model.FirewallRequest;
import com.hcloud.model.FirewallRule;
import com.hcloud.model.Reshma;
import com.hcloud.service.FirewallRequestService;
import com.hcloud.service.FirewallRuleService;
import com.hcloud.service.ReshmaService;

@Controller
public class FirewallController {

	@Autowired
	private FirewallRuleService firewallRuleService;
	
	@Autowired
	private FirewallRequestService firewallRequestService;
	
	@Autowired
	private ReshmaService reshmaService;
	
	@PostMapping(value = "/addFirewallRule")
	public String addFirewallRule(@ModelAttribute("firewall") FirewallRule firewallRule, HttpServletRequest request) {
		
		
		if(firewallRule.getValidity().equals("Permanent")) {
			firewallRule.setTillDate(null);
		}
		System.out.println("++++++++++++++++++++++++++++++ SOURCE ENVIRONMENTS ++++++++++++++++++++++++++++++++++");
		List<Reshma> res = reshmaService.getReshmaIPs(firewallRule.getSourceIp());
		
		for (Reshma r : res) {
			System.out.println("DC : "+r.getDcLocation()+"Cluster : "+r.getClusterName()+" App Type : "+r.getAppType()+" App Environment: "+r.getAppEnvironment());
		}
		
		System.out.println("+++++++++++++++++++++++++++++++ DESTINATION ENVIRONMENTS +++++++++++++++++++++++++++++++++");
List<Reshma> res2 = reshmaService.getReshmaIPs(firewallRule.getDesIp());
		
		for (Reshma r : res2) {
			System.out.println("DC : "+r.getDcLocation()+"Cluster : "+r.getClusterName()+" App Type : "+r.getAppType()+" App Environment: "+r.getAppEnvironment());
		}
		
		
		
		
		
		firewallRuleService.save(firewallRule);
		
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
