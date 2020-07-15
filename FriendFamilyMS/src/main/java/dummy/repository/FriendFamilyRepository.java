package dummy.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dummy.entity.FriendFamilyEntity;

@Repository
@Transactional
public interface FriendFamilyRepository extends CrudRepository<FriendFamilyEntity, Integer> {
	
	List<FriendFamilyEntity> findAll();
	
	@Modifying(clearAutomatically = true)
	@Query(value = "update FRIENDFAMILY f set f.PHONE_NO=:phoneNo,f.FRIEND_FAMILY=:friendAndFamily where f.ID =:id",nativeQuery = true)
	 void updateFriendFamily(@Param("phoneNo")String phoneNo,@Param("friendAndFamily")String friendAndFamily, @Param("id")Integer id);
	
	@Query(value = "select * from FRIENDFAMILY f where f.FRIEND_FAMILY=:friendFamily and f.PHONE_NO=:phoneNo",nativeQuery = true)
	List<FriendFamilyEntity> findByPhoneNoFriendFamily(@Param("phoneNo")Long phoneNo,@Param("friendFamily") String friendFamily);

}