package com.infosys.infytel.customer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.infytel.customer.dto.CustomerDTO;
import com.infosys.infytel.customer.dto.LoginDTO;
import com.infosys.infytel.customer.entity.Customer;
import com.infosys.infytel.customer.repository.CustomerRepository;

@Service
public class CustomerService {

	Logger logger = LoggerFactory.getLogger(CustomerService.class);
	
	@Autowired
	CustomerRepository custRepo;
	
	public void createCustomer(CustomerDTO custDTO) {
		logger.info("creation request for customer {}",custDTO);
		Customer cust = custDTO.createEntity();
		custRepo.save(cust);
	}
	
	public Boolean login(LoginDTO loginDTO) {
		logger.info("login request  with customer {} with password {}",loginDTO.getPhoneNo(),loginDTO.getPassword());
		Customer customer = custRepo.findById(loginDTO.getPhoneNo()).get();
		if(customer != null && customer.getPassword().equals(loginDTO.getPassword())){
			return true;
			}
		return false;
	}
	
	public CustomerDTO getCustomerProfile(Long phoneNo) {
		logger.info("profile request for customer {}",phoneNo);
		Customer cust = custRepo.findById(phoneNo).get();
		CustomerDTO custDTO = CustomerDTO.valueOf(cust);
		logger.info("profile for customer : {}",phoneNo);
		return custDTO;
	}
	
}
