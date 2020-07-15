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

import dummy.model.CallDetailsModel;
import dummy.service.CallDetailsService;

@RestController
public class CallDetailsController {
	
	@Autowired
	CallDetailsService service;
	
	
	@PostMapping(value = "/addCallDetails",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			headers = "Accept=application/json")
	public CallDetailsModel addCallDetails(@RequestBody CallDetailsModel calldetails) {
		System.out.println("inside add call details controller");
		System.out.println(calldetails);
		service.addCallDetails(calldetails);
		return calldetails;
	}
	
	@Cacheable(value = "allcdCache",unless = "#result.size() == 0")
	@GetMapping(value = "/findAllCalls",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			headers = "Accept=application/json")
	public  List<CallDetailsModel>  getAllCalls(){
		System.out.println("inside findall calls controller:");
		
		return service.findAll();
	}
	
	@PutMapping(value = "/updatecall",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			headers = "Accept=application/json")
	public  int updatecall(@RequestParam("calledTo")String calledTo,@RequestParam("calledon")String calledon, @RequestParam("id") String id) {
		System.out.println("name:"+calledTo);
		System.out.println("age:"+calledon);
		System.out.println("PhoneNo:"+id);
		service.updateCallDetails(calledTo, calledon, id);
		return 0;
	}
	
	@PutMapping(value = "/deletecall",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			headers = "Accept=application/json")
	public  int deleteCall(@RequestParam("id") String id) {
		service.deleteCallDetails(id);
		return 0;
	}
	
	@Cacheable(value = "cdCache",key = "#calledby")
	@GetMapping(value = "/findcallsCalledBy",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			headers = "Accept=application/json")
	public List<CallDetailsModel> findCallsCalledBy(@RequestParam("calledby")String calledby){
		System.out.println("inside find calls called by controller");
		System.out.println("gender:"+calledby);
		return service.findByCalledBy(calledby);
	}
}