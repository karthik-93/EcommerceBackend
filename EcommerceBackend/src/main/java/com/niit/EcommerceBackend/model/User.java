package com.niit.EcommerceBackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
public class User {
	@Id
	@GeneratedValue
	int userId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	String username;
	String password;
	String role; // Admin->Adding,Deleting,Updating Product,Category,Supplier
					// User->Add Product To cart,Update and Delete from Cart and Purchase
	boolean enabled;
	String customerName;
	String customerAddr;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddr() {
		return customerAddr;
	}

	public void setCustomerAddr(String customerAddr) {
		this.customerAddr = customerAddr;
	}

}
