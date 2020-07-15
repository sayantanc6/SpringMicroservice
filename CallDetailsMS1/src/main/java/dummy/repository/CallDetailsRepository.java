package dummy.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dummy.entity.CallDetailsEntity;

@Repository
@Transactional
public interface CallDetailsRepository extends CrudRepository<CallDetailsEntity, Long> {
	
	List<CallDetailsEntity> findAll();
	
	@Modifying(clearAutomatically = true)
	@Query(value = "update CALLDETAILS c set c.CALLED_TO= :calledTo,c.CALLED_ON =:calledon where c.ID =:id",nativeQuery = true)
	void updateCallDetails(@Param("calledTo")Long calledTo,@Param("calledon")Long calledon,@Param("id")Long id);
	
	List<CallDetailsEntity> findByCalledBy(Long calledby);

}