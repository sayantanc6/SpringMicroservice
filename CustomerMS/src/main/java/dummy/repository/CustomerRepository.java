package dummy.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dummy.entity.CustomerEntity;
import java.lang.Long;

@Repository
@Transactional
public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {
	
	List<CustomerEntity> findAll();

	  @Modifying(clearAutomatically = true)
	  @Query(value = "update CUSTOMER e set e.NAME = :name,e.AGE= :age where e.PHONE_NO= :PhoneNo",nativeQuery = true)
	  void updateNameByPhone(@Param("name")String name,@Param("age")String
	  age,@Param("PhoneNo")Long phoneNo);
	  
	  List<CustomerEntity> findByGender(Character gender);
	  
	  @Query(value = "select * from CUSTOMER e where e.PHONE_NO =:phoneno",nativeQuery = true)
	  CustomerEntity findByPhoneNo(@Param("phoneno")Long phoneno);
	 
	 
	
}