package dummy.model;

import java.io.Serializable;

import org.dozer.Mapping;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("serial")
@Component
public class CustomerModel implements Serializable{
	

	//private static final long serialVersionUID = 1L;

	@JsonProperty("PhoneNo")
	private Long PhoneNo;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("age")
	private Integer age;
	
	@JsonProperty("address")
	private String address;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("gender")
	private Character gender;
	
	@JsonProperty("planID")
	private Integer planID;

	@Mapping("PhoneNo")
	public Long getPhoneNo() {
		return PhoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		PhoneNo = phoneNo;
	}

	@Mapping("name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Mapping("age")
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Mapping("address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Mapping("password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Mapping("gender")
	public Character getGender() { 
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	@Mapping("planID")
	public Integer getPlanID() {
		return planID;
	}

	public void setPlanID(Integer planID) {
		this.planID = planID;
	}

	@Override
	public String toString() {
		return "CustomerModel [PhoneNo=" + PhoneNo + ", name=" + name + ", age=" + age + ", address=" + address
				+ ", password=" + password + ", gender=" + gender + ", planID=" + planID + "]";
	}
	
	

}