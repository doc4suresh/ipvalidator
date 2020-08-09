package com.hcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcloud.model.Firewall;
import com.hcloud.repository.FirewallRepository;
import com.hcloud.service.FirewallService;

@Service
public class FirewallServiceImpl implements FirewallService {

	@Autowired
	private FirewallRepository firewallRepository;
	
	@Override
	public Firewall save(Firewall firewall) {
		return firewallRepository.save(firewall);
	}

}
