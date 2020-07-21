package com.infosys.infytel.calldetails.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "calldetails")
public class CallDetails {
	
	@Id
	@GeneratedValue
	Long id;
	
	@Column(nullable = false)
	Long calledBy;
	
	@Column(nullable = false)
	long calledTo;
	
	@Column(nullable = false)
	Date calledOn;
	
	@Column(nullable = false)
	int duration;

	public Long getId() {
		return id;
	}

	public CallDetails() {
		super();
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCalledBy() {
		return calledBy;
	}

	public void setCalledBy(Long calledBy) {
		this.calledBy = calledBy;
	}

	public long getCalledTo() {
		return calledTo;
	}

	public void setCalledTo(long calledTo) {
		this.calledTo = calledTo;
	}

	public Date getCalledOn() {
		return calledOn;
	}

	public void setCalledOn(Date calledOn) {
		this.calledOn = calledOn;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
}
