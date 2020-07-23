package com.infosys.infytel.plan.controller;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.infytel.plan.dto.PlanDTO;
import com.infosys.infytel.plan.service.PlanService;

@RestController
@CrossOrigin
public class PlanController {
	
	private static final Logger log = LoggerFactory.getLogger(PlanController.class);
	
	@Autowired
	PlanService planService;
	
	@RequestMapping(value = "/plans",
					method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PlanDTO> getAllplans() {
		log.info("fetching all plans");
		return planService.getAllPlans();
	}
	
	@RequestMapping(value = "/plans/{planID}",
					method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public PlanDTO getSpecificPlans(@PathVariable Integer planID,HttpServletRequest request) {
		System.out.println("PLAN REQUEST IS ===="+request);
		Enumeration<String> en= request.getHeaderNames();
		List<String> li= Collections.list(en);
		System.out.println("HEADERS ARE ==="+li);
		System.out.println("Auhorization is ====="+request.getHeader("Authorization"));
		log.info("fetching details of plan {}",planID);
		System.out.println("PLAN IS ===="+planService.getSpecificPlan(planID));
		return planService.getSpecificPlan(planID);
	}

}
