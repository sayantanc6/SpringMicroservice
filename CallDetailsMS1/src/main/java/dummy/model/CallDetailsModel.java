package dummy.model;

import java.io.Serializable;

import org.dozer.Mapping;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class CallDetailsModel implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("calledBy")
	private Long calledBy;
	
	@JsonProperty("calledTo")
	private Long calledTo;
	
	@JsonProperty("calledOn")
	private Long calledOn;
	
	@Mapping("id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Mapping("calledBy")
	public Long getCalledBy() {
		return calledBy;
	}
	
	public void setCalledBy(Long calledBy) {
		this.calledBy = calledBy;
	}
	
	@Mapping("calledTo")
	public Long getCalledTo() {
		return calledTo;
	}
	
	public void setCalledTo(Long calledTo) {
		this.calledTo = calledTo;
	}
	
	@Mapping("calledOn")
	public Long getCalledOn() {
		return calledOn;
	}
	
	public void setCalledOn(Long calledOn) {
		this.calledOn = calledOn;
	}
	
	@Override
	public String toString() {
		return "CallDetailsModel [id=" + id + ", calledBy=" + calledBy + ", calledTo=" + calledTo + ", calledOn="
				+ calledOn + "]";
	}
	
	

}