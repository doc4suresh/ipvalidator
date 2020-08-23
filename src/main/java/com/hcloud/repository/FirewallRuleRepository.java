package com.hcloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcloud.model.FirewallRule;

public interface FirewallRuleRepository extends JpaRepository<FirewallRule, Long>{

}
