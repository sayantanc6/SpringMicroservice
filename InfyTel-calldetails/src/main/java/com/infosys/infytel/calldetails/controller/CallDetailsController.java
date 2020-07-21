package com.infosys.infytel.calldetails.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.infytel.calldetails.dto.CallDetailsDTO;
import com.infosys.infytel.calldetails.service.CallDetailsService;

@RestController
@CrossOrigin
public class CallDetailsController {

	
	private static final Logger log = LoggerFactory.getLogger(CallDetailsController.class);
	
	@Autowired
	CallDetailsService callDetailsService;
	
	@RequestMapping(value ="/customers/{phoneNo}/calldetails",
					method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CallDetailsDTO> getCutomerCallDetails(@PathVariable Long phoneNo){
		log.info("calldetails request for customers {}", phoneNo);
		
		return callDetailsService.getCustomerCallDetails(phoneNo);
	}
	

}
