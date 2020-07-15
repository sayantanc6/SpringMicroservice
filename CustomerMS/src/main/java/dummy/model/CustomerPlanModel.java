package dummy.model;

import java.io.Serializable;

import org.dozer.Mapping;
import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Component
public class CustomerPlanModel implements Serializable{
	

	//private static final long serialVersionUID = 1L;

	private Integer PlanID;
	
	private String planName;
	
	private Integer nationalRate;
	
	private Integer localRate;
	
	private Long PhoneNo;
	
	private String name;
	
	private Integer age;
	
	private String address;
	
	private String password;
	
	private Character gender;

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

	@Override
	public String toString() {
		return "CustomerPlanModel [PlanID=" + PlanID + ", planName=" + planName + ", nationalRate=" + nationalRate
				+ ", localRate=" + localRate + ", PhoneNo=" + PhoneNo + ", name=" + name + ", age=" + age + ", address="
				+ address + ", password=" + password + ", gender=" + gender + "]";
	}
	
	
	
	

}