package dummy.model;

import org.springframework.stereotype.Component;

@Component
public class PlanModel {


	private Integer PlanID;
	
	private String planName;
	
	private Integer nationalRate;
	
	private Integer localRate;

	public Integer getPlanID() {
		return PlanID;
	}

	public void setPlanID(Integer planID) {
		PlanID = planID;
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
		return "PlanModel [PlanID=" + PlanID + ", planName=" + planName + ", nationalRate=" + nationalRate
				+ ", localRate=" + localRate + "]";
	}
	
}