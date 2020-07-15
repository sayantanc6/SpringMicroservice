package dummy.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dummy.entity.PlanEntity;

@Repository
@Transactional
public interface PlanRepository extends CrudRepository<PlanEntity, Integer> {

	List<PlanEntity> findAll();
	
	@Modifying(clearAutomatically = true)
	@Query(value = "update PLAN p set p.PLAN_NAME= :planName,p.NATIONAL_RATE=:nationalRate where p.PLAN_ID= :PlanID",nativeQuery = true)
	void updatePlan(@Param("planName")String planName,@Param("nationalRate")Integer nationalRate,@Param("PlanID")Integer PlanID);
	
	List<PlanEntity> findByPlanName(String planName);
	
	@Query(value = "select * from PLAN p where p.PLAN_ID= :PlanID",nativeQuery = true)
	Optional<PlanEntity> findById(@Param("PlanID")Integer PlanID);
}