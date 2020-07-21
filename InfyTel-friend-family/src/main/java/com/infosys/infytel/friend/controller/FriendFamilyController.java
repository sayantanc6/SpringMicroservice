package com.infosys.infytel.friend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.infytel.friend.dto.FriendFamilyDTO;
import com.infosys.infytel.friend.service.FriendFamilyService;

@RestController
@CrossOrigin
public class FriendFamilyController {

	Logger logger = LoggerFactory.getLogger(FriendFamilyController.class);
	
	@Autowired
	FriendFamilyService friendService;
	
	@RequestMapping(value = "/customers/{phoneNo}/friends",
					method = RequestMethod.POST,
					consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveFriend(@PathVariable Long phoneNo,@RequestBody FriendFamilyDTO friendDTO) {
		logger.info("creation request for customer {} with data {}",phoneNo,friendDTO);
		friendService.saveFriend(phoneNo,friendDTO);
	}
	
	@RequestMapping(value = "/customers/{phoneNo}/friends",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Long> getSpecificFriends(@PathVariable Long phoneNo){
		logger.info("friend and family numbers for customer {}",phoneNo);
		return friendService.getSpecificFriends(phoneNo);
	}
}
