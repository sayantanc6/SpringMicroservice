package dummy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CALLDETAILS")
public class CallDetailsEntity {
	
	@Id
	@Column(name = "ID")
	Long id;
	
	@Column(name = "CALLED_BY")
	Long calledBy;
	
	@Column(name = "CALLED_TO")
	Long calledTo;
	
	@Column(name = "CALLED_ON")
	Long calledOn;

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

	public Long getCalledTo() {
		return calledTo;
	}

	public void setCalledTo(Long calledTo) {
		this.calledTo = calledTo;
	}

	public Long getCalledOn() {
		return calledOn;
	}

	public void setCalledOn(Long calledOn) {
		this.calledOn = calledOn;
	}

}
