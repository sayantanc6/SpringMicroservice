package dummy.service;

import java.util.List;

import dummy.model.FriendFamilyModel;

public interface FriendFamilyService {

	public void AddFriendFamily(FriendFamilyModel ffModel);
	public List<FriendFamilyModel> findAll();
	public int updateFriendFamily(String phoneNo, String friendAndFamily, String id);
	public int deleteFriendFamily(String id);
	public List<FriendFamilyModel> findByFriendFamilyPhoneNo(String friendAndFamily, String phoneNo);
}