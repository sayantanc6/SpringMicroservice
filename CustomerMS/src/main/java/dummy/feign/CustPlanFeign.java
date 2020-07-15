package dummy.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dummy.model.PlanModel;


@FeignClient(name ="PlanMS")
public interface CustPlanFeign {
	
	@GetMapping(value = "/findPlanID",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			headers = "Accept=application/json")
	public PlanModel findPlanID(@RequestParam("planID")String planID);

}