package dummy.service;

import java.util.List;

import dummy.model.PlanModel;

public interface PlanService {
	
	public void AddPlan(PlanModel plan);
	public List<PlanModel> findAll();
	public int updatePlan(String planName, String nationalRate, String PlanID);
	public int deletePlan(String PlanID);
	public List<PlanModel> findByPlanName(String planName);
	public PlanModel findByPlanID(String PlanID);

}