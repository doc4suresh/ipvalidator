package com.hcloud.service;


import java.util.List;

import com.hcloud.model.FirewallRule;

public interface FirewallRuleService {

	FirewallRule save(FirewallRule firewallRule);
	
	FirewallRule getBySN(long sn);
	
	void deleteById(long id);

	List<FirewallRule> getAllFirewallRules();
	
	void updateFirewallRules(long requestId);
	
	List<FirewallRule> getPendingFirewallRules();
}
