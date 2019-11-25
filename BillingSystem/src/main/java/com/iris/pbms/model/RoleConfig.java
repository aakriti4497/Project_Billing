package com.iris.pbms.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="RoleConfig1")
public class RoleConfig {
    
	


	@Id
    @GeneratedValue
    @Column(name="configid")
	private int configId;
    
	
	@Column(name="perHourBill")
	private int perHourBill;
    
	
	@Column(name="location")
	private String location;
    
	
	@ManyToOne
    @JoinColumn(name="projectid",insertable=false,updatable=false)
	Projects proObj;



	@ManyToOne
	@JoinColumn(name="roleid",insertable=false,updatable=false)
	EmployeeRole roleObj;
	
	private int projectId;
	private int roleId;



	public int getConfigId() {
		return configId;
	}



	public void setConfigId(int configId) {
		this.configId = configId;
	}



	public int getPerHourBill() {
		return perHourBill;
	}



	public void setPerHourBill(int perHourBill) {
		this.perHourBill = perHourBill;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public Projects getProObj() {
		return proObj;
	}



	public void setProObj(Projects proObj) {
		this.proObj = proObj;
	}



	public EmployeeRole getRoleObj() {
		return roleObj;
	}



	public void setRoleObj(EmployeeRole roleObj) {
		this.roleObj = roleObj;
	}



	public int getProjectId() {
		return projectId;
	}



	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}



	public int getRoleId() {
		return roleId;
	}



	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}



	@Override
	public String toString() {
		return "RoleConfig [configId=" + configId + ", perHourBill=" + perHourBill + ", location=" + location
				+ ", proObj=" + proObj + ", roleObj=" + roleObj + ", projectId=" + projectId + ", roleId=" + roleId
				+ "]";
	}



	

}