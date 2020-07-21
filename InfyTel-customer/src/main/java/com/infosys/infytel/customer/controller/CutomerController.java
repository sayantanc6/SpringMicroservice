package com.infosys.infytel.customer.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infosys.infytel.customer.dto.CustomerDTO;
import com.infosys.infytel.customer.dto.LoginDTO;
import com.infosys.infytel.customer.dto.PlanDTO;
import com.infosys.infytel.customer.service.CustomerService;

@RestController
@CrossOrigin
public class CutomerController {

	Logger logger = LoggerFactory.getLogger(CutomerController.class);
	
	@Autowired
	CustomerService custService;
	
	@Value("${friend.uri}")
	String friendURI;
	
	@Value("${path.uri}")
	String pathURI;
	
	@RequestMapping(value = "/customers",
					method = RequestMethod.POST,
					consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createCustomer(@RequestBody CustomerDTO custDTO){
		logger.info("Creation request for customer {}",custDTO);
		custService.createCustomer(custDTO);
	}
	
	@RequestMapping(value = "/login",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Boolean login(@RequestBody LoginDTO loginDTO) {
		logger.info("Login request for customer {} with password {}",loginDTO.getPhoneNo(),loginDTO.getPassword());
		return custService.login(loginDTO);
	}
	
	@RequestMapping(value = "/customers/{phoneNo}",
			method = RequestMethod.GET,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public CustomerDTO getCustomerProfile(@PathVariable Long phoneNo) {
		logger.info("Creation request for customer {}",phoneNo);
		
		CustomerDTO custDTO = custService.getCustomerProfile(phoneNo);
		PlanDTO planDTO = new RestTemplate().getForObject(pathURI+custDTO.getCurrentplan().getPlanID(), PlanDTO.class);
		custDTO.setCurrentplan(planDTO); 
		
		@SuppressWarnings("unchecked")
		List<Long> friends = new RestTemplate().getForObject(friendURI+phoneNo+"/friends", List.class);
		custDTO.setFriendAndFamily(friends);
		return custDTO;
	}
}
