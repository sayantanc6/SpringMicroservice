package com.infosys.infytel.customer.controller;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
	
	@Autowired
	RestTemplate template;
	
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
	public CustomerDTO getCustomerProfile(@PathVariable Long phoneNo,@RequestHeader HttpHeaders headers,HttpServletRequest request) throws InterruptedException,ExecutionException{
		System.out.println("REQUEST IS======"+request);
		System.out.println("HEADERS IS====="+headers);
		System.out.println("Key Set is====="+headers.keySet());
		System.out.println("User Agent "+headers.getFirst("user-agent"));
		System.out.println("Authorization "+headers.getFirst("Authorization"));
		Enumeration<String> en= request.getHeaderNames();
		List<String> li=Collections.list(en);
		System.out.println("HEADERS ARE ======"+li);
		System.out.println("AUTHORIZATION IS ====="+request.getHeader("Authorization"));
		logger.info("Creation request for customer {}",phoneNo);
		
		CustomerDTO custDTO = custService.getCustomerProfile(phoneNo);
		HttpEntity<String> request2 = new HttpEntity<String>(headers);
		ResponseEntity<PlanDTO> planDTO= template.exchange("http://PlanMS/plans/"+custDTO.getCurrentplan().getPlanID(),HttpMethod.GET,request2, PlanDTO.class);

		ResponseEntity<List> friendList= template.exchange("http://FriendFamilyMS/customers/"+phoneNo+"/friends",HttpMethod.GET,request2, List.class);
		custDTO.setCurrentplan(planDTO.getBody());
		custDTO.setFriendAndFamily(friendList.getBody());
		return custDTO;
	}
}
