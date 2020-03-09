package dummy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FRIENDFAMILY")
public class FriendFamilyEntity {
	
	@Id
	@Column(name = "ID")
	Integer id;
	
	@Column(name = "PHONE_NO")
	Long phoneNo;
	
	@Column(name = "FRIEND_FAMILY")
	Long friendAndFamily;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Long getFriendAndFamily() {
		return friendAndFamily;
	}

	public void setFriendAndFamily(Long friendAndFamily) {
		this.friendAndFamily = friendAndFamily;
	}

}
 