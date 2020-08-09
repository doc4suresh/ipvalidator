package com.hcloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcloud.model.Firewall;

public interface FirewallRepository extends JpaRepository<Firewall, Long>{

}
