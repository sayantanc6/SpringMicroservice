package com.infosys.infytel.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	@Column(name = "phone_no",nullable = false)
	long phoneNo;
	
	@Column(nullable = false,length = 50)
	String name;
	
	@Column(nullable = false)
	int age;
	
	@Column(nullable = false,length = 1)
	char gender;
	
	@Column(nullable = false,length = 50)
	String password;
	
	@Column(nullable = false,length = 50)
	String address;
	
	@Column(name = "plan_id",nullable = false)
	Integer planId;

	public Customer() {
		super();
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
}
