package com.hcloud.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcloud.model.FirewallRequest;
import com.hcloud.repository.FirewallRequestRepository;
import com.hcloud.service.FirewallRequestService;

@Service
public class FirewallRequestServiceImpl implements FirewallRequestService{

	@Autowired
	private FirewallRequestRepository firewallRequestRepository;
	
	
	@Override
	public FirewallRequest save(FirewallRequest firewallRequests) {
		return firewallRequestRepository.save(firewallRequests);
	}

	@Override
	public List<FirewallRequest> getAllFirewallRequests() {
		List<FirewallRequest> result = (List<FirewallRequest>) firewallRequestRepository.findAll();
        
        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<FirewallRequest>();
        }
	}
	

}
