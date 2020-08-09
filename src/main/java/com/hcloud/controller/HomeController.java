package com.hcloud.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hcloud.model.Firewall;
import com.hcloud.service.FirewallService;

@Controller
public class HomeController {
	
	@Autowired
	private FirewallService firewallService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		Firewall firewall = new Firewall();
		model.addAttribute("firewall", firewall);

		return "index";
	}
	
	@PostMapping(value = "/addFirewall")
	public String addFirewall(@ModelAttribute("firewall") Firewall firewall, HttpServletRequest request) {
		firewallService.save(firewall);
		
		return "index";
	}
}
