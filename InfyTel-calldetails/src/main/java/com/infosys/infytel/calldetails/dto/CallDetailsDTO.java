package com.infosys.infytel.calldetails.dto;

import java.sql.Date;

import com.infosys.infytel.calldetails.entity.CallDetails;

public class CallDetailsDTO {

	Long id;
	
	Long calledBy;
	
	long calledTo;
	
	Date calledOn;
	
	int duration;

	public CallDetailsDTO() {
		super();
	}

	public CallDetailsDTO(Long id, Long calledBy, long calledTo, Date calledOn, int duration) {
		super();
		this.id = id;
		this.calledBy = calledBy;
		this.calledTo = calledTo;
		this.calledOn = calledOn;
		this.duration = duration;
	}

	public Long getId() {
		return id;
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
	
	public static CallDetailsDTO valueOf(CallDetails callDetails) {
		CallDetailsDTO callsDTO = new CallDetailsDTO();
		callsDTO.setCalledBy(callDetails.getCalledBy());
		callsDTO.setCalledTo(callDetails.getCalledTo());
		callsDTO.setCalledOn(callDetails.getCalledOn());
		return callsDTO;
	}

	@Override
	public String toString() {
		return "CallDetailsDTO [id=" + id + ", calledBy=" + calledBy + ", calledTo=" + calledTo + ", calledOn="
				+ calledOn + ", duration=" + duration + "]";
	}
	
	
}
