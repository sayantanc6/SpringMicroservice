package dummy.model;

import java.io.Serializable;

import org.dozer.Mapping;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class PlanModel implements Serializable{
	


	private static final long serialVersionUID = 1L;

	@JsonProperty("PlanID")
	private Integer PlanID;
	
	@JsonProperty("planName")
	private String planName;
	
	@JsonProperty("nationalRate")
	private Integer nationalRate;
	
	@JsonProperty("localRate")
	private Integer localRate;

	@Mapping("PlanID")
	public Integer getPlanID() {
		return PlanID;
	}

	public void setPlanID(Integer planID) {
		PlanID = planID;
	}

	@Mapping("planName")
	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	@Mapping("nationalRate")
	public Integer getNationalRate() {
		return nationalRate;
	}

	public void setNationalRate(Integer nationalRate) {
		this.nationalRate = nationalRate;
	}

	@Mapping("localRate")
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