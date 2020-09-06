package com.hcloud.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.hcloud.model.FirewallRule;

public interface FirewallRuleRepository extends JpaRepository<FirewallRule, Long>{

	@Transactional
	@Modifying
    @Query(value = "UPDATE firewall_rule f set request_id =:request_id where request_id is null",
            nativeQuery = true)
	void updateFirewallRules(@Param("request_id") long requestId);
 
    
    @Query(value = "Select * from firewall_rule f where request_id is null",
            nativeQuery = true)
	List<FirewallRule> getPendingFirewallRules();
    
    
    
}
