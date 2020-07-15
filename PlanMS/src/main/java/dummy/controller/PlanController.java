package dummy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dummy.model.PlanModel;
import dummy.service.PlanService;

@RestController
public class PlanController {
	
	
	@Autowired
	PlanService service;

	@PostMapping(value = "/addplan",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			headers = "Accept=application/json")
			public  PlanModel addCustomer(@RequestBody PlanModel plan) {
			System.out.println("inside addplan controller");
			System.out.println(plan);
			service.AddPlan(plan);

		return plan;
		}
	
	@Cacheable(value = "allPlansCache",unless = "#result.size() == 0")
	@GetMapping(value = "/findAllPlans",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			headers = "Accept=application/json")
	public  List<PlanModel>  getAllPlans(){
		System.out.println("inside findall plans controller:");
		
		return service.findAll();
	}
	
	@PutMapping(value = "/updateplan",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			headers = "Accept=application/json")
	public  int updatePlan(@RequestParam("planName")String planName,@RequestParam("nationalRate")String nationalRate, @RequestParam("PlanID") String PlanID) {
		System.out.println("planName:"+planName);
		System.out.println("nationalRate:"+nationalRate);
		System.out.println("PlanID:"+PlanID);
		service.updatePlan(planName,nationalRate,PlanID);
		return 0;
	}
	
	@PutMapping(value = "/deleteplan",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			headers = "Accept=application/json")
	public  int deletePlan(@RequestParam("PlanID") String PlanID) {
		service.deletePlan(PlanID);
		return 0;
	}
	
	@Cacheable(value = "planCache",key = "#planName")
	@GetMapping(value = "/findPlanName",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			headers = "Accept=application/json")
	public List<PlanModel> findPlanName(@RequestParam("planName")String planName){
		System.out.println("inside find planName controller");
		System.out.println("planName:"+planName);
		return service.findByPlanName(planName);
		
	}
	
	@Cacheable(value = "planCache",key = "#planID")
	@GetMapping(value = "/findPlanID",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			headers = "Accept=application/json")
	public PlanModel findPlanID(@RequestParam("planID")String planID){
		System.out.println("inside find planID controller");
		System.out.println("planID:"+planID);
		return service.findByPlanID(planID);
	}
	
}