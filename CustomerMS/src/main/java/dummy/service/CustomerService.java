package dummy.service;

import java.util.List;

import dummy.model.CustomerModel;

public interface CustomerService {
	
	public void AddCustomer(CustomerModel cust);
	public List<CustomerModel> findAll();
	public int updateCustomer(String name, String age, String phoneNo);
	public int deleteCustomer(String PhoneNo);
	public List<CustomerModel> findByGender(Character gender);
	public CustomerModel findByPhoneNo(String phoneNo);

}