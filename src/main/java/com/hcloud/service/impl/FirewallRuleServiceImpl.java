package com.hcloud.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hcloud.model.FirewallRule;
import com.hcloud.repository.FirewallRuleRepository;
import com.hcloud.service.FirewallRuleService;

@Service
public class FirewallRuleServiceImpl implements FirewallRuleService{

	@Autowired
	private FirewallRuleRepository firewallRuleRepository;
	
	
	@Override
	public FirewallRule save(FirewallRule firewallRule) {
		return firewallRuleRepository.save(firewallRule);
	}
	
	@Override
	public void deleteById(long id) {
		firewallRuleRepository.deleteById(id);
	}
	
	@Override
	public List<FirewallRule> getAllFirewallRules()
    {
        List<FirewallRule> result = (List<FirewallRule>) firewallRuleRepository.findAll();
         
        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<FirewallRule>();
        }
    }

	
	@Override
	public void updateFirewallRules(long requestId) {
		firewallRuleRepository.updateFirewallRules(requestId);
	}

	@Override
	public List<FirewallRule> getPendingFirewallRules() {
		return firewallRuleRepository.getPendingFirewallRules();
	}
}
