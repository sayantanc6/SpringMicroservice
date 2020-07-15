package dummy.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dummy.entity.FriendFamilyEntity;
import dummy.model.FriendFamilyModel;
import dummy.repository.FriendFamilyRepository;

@Service
public class FriendFamilyServiceImpl implements FriendFamilyService {
	
	@Autowired
	FriendFamilyRepository repo;
	
	@Autowired
	DozerBeanMapper mapper;
	
	List<FriendFamilyModel> friendFamilyModels;

	@Override
	public void AddFriendFamily(FriendFamilyModel ffmodel) {
		repo.save(mapper.map(ffmodel, FriendFamilyEntity.class));
	}

	@Override
	public List<FriendFamilyModel> findAll() {
		List<FriendFamilyEntity> entities = repo.findAll();
		friendFamilyModels = new ArrayList<FriendFamilyModel>();
		for (FriendFamilyEntity friendFamilyEntity : entities) {
			friendFamilyModels.add(mapper.map(friendFamilyEntity, FriendFamilyModel.class));
		}
		return friendFamilyModels;
	}

	@Override
	public int updateFriendFamily(String phoneNo, String friendAndFamily, String id) {
		repo.updateFriendFamily(phoneNo, friendAndFamily, Integer.parseInt(id));
		return 0;
	}

	@Override
	public int deleteFriendFamily(String id) {
		repo.deleteById(Integer.parseInt(id));
		return 0;
	}

	@Override
	public List<FriendFamilyModel> findByFriendFamilyPhoneNo(String friendAndFamily, String phoneNo) {
		List<FriendFamilyEntity> entities = repo.findByPhoneNoFriendFamily(Long.parseLong(phoneNo), friendAndFamily);
		friendFamilyModels = new ArrayList<FriendFamilyModel>();
		for (FriendFamilyEntity friendFamilyEntity : entities) {
			friendFamilyModels.add(mapper.map(friendFamilyEntity, FriendFamilyModel.class));
		}
		return friendFamilyModels;
	}

}