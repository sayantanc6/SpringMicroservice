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

import dummy.model.FriendFamilyModel;
import dummy.service.FriendFamilyService;

@RestController
public class FriendFamilyController {
	
	@Autowired
	FriendFamilyService service;

	@PostMapping(value = "/addFriendFamily",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			headers = "Accept=application/json")
			public  FriendFamilyModel addFriendFamily(@RequestBody FriendFamilyModel ff) {
			System.out.println("inside add ff controller");
			System.out.println(ff);
			service.AddFriendFamily(ff);

		return ff;
		}
	
	@Cacheable(value = "allffCache",unless = "#result.size() == 0")
	@GetMapping(value = "/findAllff",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			headers = "Accept=application/json")
	public  List<FriendFamilyModel>  getAllff(){
		System.out.println("inside findall ff controller:");
		
		return service.findAll();
	}
	
	@PutMapping(value = "/updateff",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			headers = "Accept=application/json")
	public  int updateff(@RequestParam("phoneNo")String phoneNo,@RequestParam("friendAndFamily")String friendAndFamily, @RequestParam("id") String id) {
		System.out.println("phoneNo:"+phoneNo);
		System.out.println("friendAndFamily:"+friendAndFamily);
		System.out.println("id:"+id);
		service.updateFriendFamily(phoneNo,friendAndFamily,id);
		return 0;
	}
	
	@PutMapping(value = "/deleteff",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			headers = "Accept=application/json")
	public  int deleteCust(@RequestParam("id") String id) {
		service.deleteFriendFamily(id);
		return 0;
	}
	 
	@Cacheable(value = "ffCache", key = "#phoneNo")
	@GetMapping(value = "/findff",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			headers = "Accept=application/json")
	public List<FriendFamilyModel> findff(@RequestParam("friendAndFamily")String friendAndFamily,@RequestParam("phoneNo")String phoneNo){
		System.out.println("inside find ff controller");
		System.out.println("friendAndFamily:"+friendAndFamily);
		return service.findByFriendFamilyPhoneNo(friendAndFamily,phoneNo);
		
	}

}