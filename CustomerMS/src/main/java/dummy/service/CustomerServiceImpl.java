package dummy.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dummy.entity.CustomerEntity;
import dummy.model.CustomerModel;
import dummy.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository repo;
	
	@Autowired
	DozerBeanMapper mapper;
	
	List<CustomerModel> custModels;

	@Override
	public void AddCustomer(CustomerModel cust) {
		System.out.println("inside customer service:" + cust);
		repo.save(mapper.map(cust, CustomerEntity.class));

	} 
 
	@Override
	public List<CustomerModel> findAll() { 
		List<CustomerEntity> entityList = repo.findAll();
		custModels = new ArrayList<CustomerModel>();
		for (CustomerEntity customerEntity : entityList) {
			custModels.add(mapper.map(customerEntity, CustomerModel.class));
		}
		return custModels;
	}

	@Override
	public int updateCustomer(String name, String age, String PhoneNo) {
		System.out.println("inside update cust service:");
		repo.updateNameByPhone(name,age, Long.parseLong(PhoneNo));
		return 0;
	}

	@Override
	public int deleteCustomer(String PhoneNo) {
		repo.deleteById(Long.parseLong(PhoneNo)); 
		return 0;
	}

	@Override
	public List<CustomerModel> findByGender(Character gender) {
		System.out.println("inside service gender");
		List<CustomerEntity> entities = repo.findByGender(gender);
		custModels = new ArrayList<CustomerModel>();
		for (CustomerEntity customerEntity : entities) {
			custModels.add(mapper.map(customerEntity, CustomerModel.class));
		}
		return custModels;
	}

	@Override
	public CustomerModel findByPhoneNo(String phoneNo) {
		CustomerEntity entity = repo.findByPhoneNo(Long.parseLong(phoneNo));
		return mapper.map(entity, CustomerModel.class);
	}

}