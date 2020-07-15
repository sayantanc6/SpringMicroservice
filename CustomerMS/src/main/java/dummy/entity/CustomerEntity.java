package dummy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class CustomerEntity {
	
	@Id
	@Column(name = "PHONE_NO")
	Long PhoneNo;
	
	@Column(name = "NAME")
	String name;
	
	@Column(name = "AGE")
	Integer age;
	
	@Column(name = "ADDRESS")
	String address;
	
	@Column(name = "PASSWORD")
	String password;
	
	@Column(name = "GENDER")
	Character gender;
	
	@Column(name = "PLANID")
	Integer planID;

	public Long getPhoneNo() {
		return PhoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		PhoneNo = phoneNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Character getGender() { 
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public Integer getPlanID() {
		return planID;
	}

	public void setPlanID(Integer planID) {
		this.planID = planID;
	}

	@Override
	public String toString() {
		return "CustomerEntity [PhoneNo=" + PhoneNo + ", name=" + name + ", age=" + age + ", address=" + address
				+ ", password=" + password + ", gender=" + gender + ", planID=" + planID + "]";
	}
	
	
}