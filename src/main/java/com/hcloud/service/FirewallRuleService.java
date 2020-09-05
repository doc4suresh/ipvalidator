package com.hcloud.service;


import java.util.List;

import com.hcloud.model.FirewallRule;

public interface FirewallRuleService {

	FirewallRule save(FirewallRule firewallRule);

	List<FirewallRule> getAllFirewallRules();
	
	void updateFirewallRules(long requestId);
	
	
	List<FirewallRule> getPendingFirewallRules();
}
