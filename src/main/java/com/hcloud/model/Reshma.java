package com.hcloud.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reshma")
public class Reshma {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable=false, updatable=false)
	private long id;
	
	@Column(name = "ip_range")
	private String ipRange;
	
	@Column(name = "name")
	private String Name;
	
	@Column(name = "zone_name")
	private String zoneName;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "create_date")
	private Date createDate;

	@Column(name = "last_modified_date")
	private Date lastModifiedDate;
	
	@Column(name = "dc_location")
	private String dcLocation;

	@Column(name = "cluster_name")
	private String clusterName;
	
	@Column(name = "app_type")
	private String appType;
	
	@Column(name = "app_environment")
	private String appEnvironment;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIpRange() {
		return ipRange;
	}

	public void setIpRange(String ipRange) {
		this.ipRange = ipRange;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getDcLocation() {
		return dcLocation;
	}

	public void setDcLocation(String dcLocation) {
		this.dcLocation = dcLocation;
	}

	public String getClusterName() {
		return clusterName;
	}

	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	public String getAppEnvironment() {
		return appEnvironment;
	}

	public void setAppEnvironment(String appEnvironment) {
		this.appEnvironment = appEnvironment;
	}

	
}
