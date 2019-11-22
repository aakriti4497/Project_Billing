package com.iris.pbms.model;



import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Table;



@Entity

@Table(name="usertable")

public class UserTable {

	

	@Id

	@Column(name="userid")

    private int userId;



	@Column(name="PassD")

    private String password;



	@Column(name="role")

	private String Role;



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getRole() {
		return Role;
	}



	public void setRole(String Role) {
		this.Role = Role;
	}



	@Override
	public String toString() {
		return "UserTable [userId=" + userId + ", password=" + password + ", Role=" + Role + "]";
	}



	

}