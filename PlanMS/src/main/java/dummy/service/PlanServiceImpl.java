package dummy.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dummy.entity.PlanEntity;
import dummy.model.PlanModel;
import dummy.repository.PlanRepository;

@Service
public class PlanServiceImpl implements PlanService {
	
	@Autowired
	PlanRepository repo;
	
	@Autowired
	DozerBeanMapper mapper;
	
	List<PlanModel> planModels;

	@Override
	public void AddPlan(PlanModel plan) {
		repo.save(mapper.map(plan, PlanEntity.class));
	}

	@Override
	public List<PlanModel> findAll() {
		List<PlanEntity> entities = repo.findAll();
		planModels = new ArrayList<PlanModel>();
		for (PlanEntity planEntity : entities) {
			planModels.add(mapper.map(planEntity, PlanModel.class));
		}
		return planModels;
	}

	@Override
	public int updatePlan(String planName, String nationalRate, String PlanID) {
		repo.updatePlan(planName,Integer.parseInt(nationalRate),Integer.parseInt(PlanID)); 
		return 0;
	}

	@Override
	public int deletePlan(String PlanID) {
		repo.deleteById(Integer.parseInt(PlanID)); 
		return 0;
	}

	@Override
	public List<PlanModel> findByPlanName(String planName) {
		List<PlanEntity> entities = repo.findByPlanName(planName);
		planModels = new ArrayList<PlanModel>();
		for (PlanEntity planEntity : entities) {
			planModels.add(mapper.map(planEntity, PlanModel.class));
		}
		return planModels;
	}

	@Override
	public PlanModel findByPlanID(String PlanID) {
		PlanEntity entity = repo.findById(Integer.parseInt(PlanID)).orElse(null);
		return mapper.map(entity, PlanModel.class);
	}

}