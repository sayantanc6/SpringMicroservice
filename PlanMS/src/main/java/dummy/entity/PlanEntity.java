package dummy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PLAN")
public class PlanEntity {
	
	@Id
	@Column(name = "PLAN_ID")
	Integer PlanID;
	
	@Column(name = "PLAN_NAME")
	String planName;
	
	@Column(name = "NATIONAL_RATE")
	Integer nationalRate;
	
	@Column(name = "LOCAL_RATE")
	Integer localRate;

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

}
