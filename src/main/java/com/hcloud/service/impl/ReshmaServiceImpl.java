package com.hcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcloud.model.Reshma;
import com.hcloud.repository.ReshmaRepository;
import com.hcloud.service.ReshmaService;

@Service
public class ReshmaServiceImpl implements ReshmaService{

	@Autowired
	private ReshmaRepository reshmaRepository;
	
	
	@Override
	public List<Reshma> getReshmaIPs(String ipAddress) {
		return reshmaRepository.getReshma(ipAddress);
	}
}
