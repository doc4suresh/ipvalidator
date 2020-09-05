package com.hcloud.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "firewall_request")
public class FirewallRequest {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="request_id", nullable=false, updatable=false)
		private long request_id;
		
		@Column(name = "request_by")
		private String requestedBy;
		
		@Column(name = "approved_by")
		private String approvedBy;
		
		@OneToMany(
		        mappedBy = "firewallRequest",
		        cascade = CascadeType.PERSIST,
		        fetch = FetchType.LAZY
		    )
		    private Set<FirewallRule> firewallRule;
		
		
		
		

		public long getRequest_id() {
			return request_id;
		}

		public void setRequest_id(long request_id) {
			this.request_id = request_id;
		}

		public String getRequestedBy() {
			return requestedBy;
		}

		public void setRequestedBy(String requestedBy) {
			this.requestedBy = requestedBy;
		}

		public String getApprovedBy() {
			return approvedBy;
		}

		public void setApprovedBy(String approvedBy) {
			this.approvedBy = approvedBy;
		}

		public Set<FirewallRule> getFirewallRule() {
			return firewallRule;
		}

		public void setFirewallRule(Set<FirewallRule> firewallRule) {
			this.firewallRule = firewallRule;
		}
		
}
