package com.hcloud.service;

import java.util.List;


import com.hcloud.model.FirewallRequest;

public interface FirewallRequestService {
	FirewallRequest save(FirewallRequest firewallRequests);

	List<FirewallRequest> getAllFirewallRequests();
	
	
	
}
