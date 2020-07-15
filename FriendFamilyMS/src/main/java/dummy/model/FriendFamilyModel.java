package dummy.model;

import java.io.Serializable;

import org.dozer.Mapping;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class FriendFamilyModel implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private Integer id;
	
	@JsonProperty("phoneNo")
	private Long phoneNo;
	
	@JsonProperty("friendAndFamily")
	private Long friendAndFamily;

	@Mapping("id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Mapping("phoneNo")
	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Mapping("friendAndFamily")
	public Long getFriendAndFamily() {
		return friendAndFamily;
	}

	public void setFriendAndFamily(Long friendAndFamily) {
		this.friendAndFamily = friendAndFamily;
	}

	@Override
	public String toString() {
		return "FriendFamilyModel [id=" + id + ", phoneNo=" + phoneNo + ", friendAndFamily=" + friendAndFamily + "]";
	}
	
	

}