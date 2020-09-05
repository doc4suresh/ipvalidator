package com.hcloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcloud.model.FirewallRequest;

public interface FirewallRequestRepository extends JpaRepository<FirewallRequest, Long>{

}
