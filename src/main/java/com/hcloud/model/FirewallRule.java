package com.hcloud.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "firewall_rule")
public class FirewallRule {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="serial_no", nullable=false, updatable=false)
	private long serialNo;

	@Column(name = "action")
	private String action;

	@Column(name = "source_hostname")
	private String sourceHostname;

	@Column(name = "source_ip")
	private String sourceIp;

	@Column(name = "source_nat_ip")
	private String sourceNatIp;

	@Column(name = "des_hostname")
	private String desHostname;

	@Column(name = "des_ip")
	private String desIp;

	@Column(name = "des_protocal")
	private String desProtocal;

	@Column(name = "des_port")
	private int desPort;

	@Column(name = "rule_action")
	private String ruleAction;

	@Column(name = "description")
	private String description;

	@Column(name = "request_by")
	private String requestBy;

	@Column(name = "approved_by")
	private String approvedBy;

	@Column(name = "validity")
	private String validity;

	@Column(name = "till_date")
	private Date tillDate;

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "justification")
	private String justification;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "request_id", referencedColumnName = "request_id")
    private FirewallRequest firewallRequest;

	public long getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(long serialNo) {
		this.serialNo = serialNo;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getSourceHostname() {
		return sourceHostname;
	}

	public void setSourceHostname(String sourceHostname) {
		this.sourceHostname = sourceHostname;
	}

	public String getSourceIp() {
		return sourceIp;
	}

	public void setSourceIp(String sourceIp) {
		this.sourceIp = sourceIp;
	}

	public String getSourceNatIp() {
		return sourceNatIp;
	}

	public void setSourceNatIp(String sourceNatIp) {
		this.sourceNatIp = sourceNatIp;
	}

	public String getDesHostname() {
		return desHostname;
	}

	public void setDesHostname(String desHostname) {
		this.desHostname = desHostname;
	}

	public String getDesIp() {
		return desIp;
	}

	public void setDesIp(String desIp) {
		this.desIp = desIp;
	}

	public String getDesProtocal() {
		return desProtocal;
	}

	public void setDesProtocal(String desProtocal) {
		this.desProtocal = desProtocal;
	}

	public int getDesPort() {
		return desPort;
	}

	public void setDesPort(int desPort) {
		this.desPort = desPort;
	}

	public String getRuleAction() {
		return ruleAction;
	}

	public void setRuleAction(String ruleAction) {
		this.ruleAction = ruleAction;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRequestBy() {
		return requestBy;
	}

	public void setRequestBy(String requestBy) {
		this.requestBy = requestBy;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

	public Date getTillDate() {
		return tillDate;
	}

	public void setTillDate(Date tillDate) {
		this.tillDate = tillDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public FirewallRequest getFirewallRequest() {
		return firewallRequest;
	}

	public void setFirewallRequest(FirewallRequest firewallRequest) {
		this.firewallRequest = firewallRequest;
	}
	
}
