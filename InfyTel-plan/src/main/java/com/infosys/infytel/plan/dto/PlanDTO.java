package com.infosys.infytel.plan.dto;

import com.infosys.infytel.plan.entity.Plan;

public class PlanDTO {

	Integer planId;
	
	String planName;
	
	Integer nationalRate;
	
	Integer localRate;

	public PlanDTO() {
		super();
	}

	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public Integer getNationalRate() {
		return nationalRate;
	}

	public void setNationalRate(Integer nationalRate) {
		this.nationalRate = nationalRate;
	}

	public Integer getLocalRate() {
		return localRate;
	}

	public void setLocalRate(Integer localRate) {
		this.localRate = localRate;
	}

	@Override
	public String toString() {
		return "PlanDTO [planId=" + planId + ", planName=" + planName + ", nationalRate=" + nationalRate + "]";
	}
	
	public static PlanDTO valueOf(Plan plan) {
		PlanDTO planDTO = new PlanDTO();
		planDTO.setLocalRate(plan.getLocalRate());
		planDTO.setNationalRate(plan.getNationalRate());
		planDTO.setPlanName(plan.getPlanName());
		planDTO.setPlanId(plan.getPlanId());
		return planDTO;
	}
	
}
