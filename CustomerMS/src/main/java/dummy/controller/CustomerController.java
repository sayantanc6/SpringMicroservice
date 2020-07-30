package dummy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.reflect.Field;

import dummy.feign.CustPlanFeign;
import dummy.model.CustomerModel;
import dummy.model.CustomerPlanModel;
import dummy.model.PlanModel;
import dummy.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService service;
	
	@Autowired
	CustPlanFeign planFeign;
	
	@Autowired
	ApplicationContext context;
	
	@Autowired
	CustomerPlanModel cpmodel;
	

	
	@PostMapping(value = "/addCustomer",
					produces = MediaType.APPLICATION_JSON_VALUE,
					consumes = MediaType.APPLICATION_JSON_VALUE,
					headers = "Accept=application/json")
	public  CustomerModel addCustomer(@Valid @RequestBody CustomerModel cust) {
		System.out.println("inside addcust controller");
		System.out.println(cust);
		//System.out.println("after service call");
		service.AddCustomer(cust);
		
		return cust;
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> addCustExceptions(MethodArgumentNotValidException ex){
		Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
	}
	
	@Cacheable(value = "allCustomersCache",unless= "#result.size() == 0")
	@GetMapping(value = "/findAllCustomers",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			headers = "Accept=application/json")
	public  List<CustomerModel>  getAllCusts(){
		System.out.println("inside findall custs controller:");
		
		return service.findAll();
	}
	
	
	@PutMapping(value = "/updatecust",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			headers = "Accept=application/json")
	public  int updatecust(@RequestParam("name")String name,@RequestParam("age")String age, @RequestParam("PhoneNo") String PhoneNo) {
		System.out.println("name:"+name);
		System.out.println("age:"+age);
		System.out.println("PhoneNo:"+PhoneNo);
		service.updateCustomer(name, age, PhoneNo);
		return 0;
	}
	
	@PutMapping(value = "/deletecust",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			headers = "Accept=application/json")
	public  int deleteCust(@RequestParam("PhoneNo") String PhoneNo) {
		service.deleteCustomer(PhoneNo);
		return 0;
	}
	
	@Cacheable(value = "customerCache",key = "#CustomerModel.gender")
	@GetMapping(value = "/findcustgender",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			headers = "Accept=application/json")
	public List<CustomerModel> findGender(@RequestParam("gender")Character gender){
		System.out.println("inside find gender controller");
		System.out.println("gender:"+gender);
		return service.findByGender(gender);
	}
	
	@Cacheable(value = "customerCache",key = "#phoneNo")
	@GetMapping(value = "/findByPhoneNo",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			headers = "Accept=application/json")
	public CustomerModel findPhone(@RequestParam("phoneNo")String phoneNo){
		System.out.println("inside find phoneNo controller");
		System.out.println("phoneNo:"+phoneNo);
		return service.findByPhoneNo(phoneNo);
	}
	
	@Cacheable(value = "customerCache",key = "#phoneNo")
	@GetMapping(value = "/findCustPlan",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			headers = "Accept=application/json")
	public CustomerPlanModel findCustPlan(@RequestParam("phoneNo")String phoneNo) throws IllegalArgumentException, IllegalAccessException{
		System.out.println("inside find custPlan controller");
		System.out.println("phoneNo:"+phoneNo);
		CustomerModel custmodel = service.findByPhoneNo(phoneNo);
		System.out.println(custmodel);
		int planID = custmodel.getPlanID();
		System.out.println("planID:"+planID);
		PlanModel planModel = planFeign.findPlanID(String.valueOf(planID));
		System.out.println(planModel);
		
		Field[] custplanfields = cpmodel.getClass().getDeclaredFields();
		Field[] planfields = planModel.getClass().getDeclaredFields();
		Field[] custFields = custmodel.getClass().getDeclaredFields();
		for (Field custplanfield : custplanfields) {
			custplanfield.setAccessible(true);
			for (Field planfield : planfields) {
				planfield.setAccessible(true);
				if (custplanfield.getName() == planfield.getName()) 
					custplanfield.set(cpmodel, planfield.get(planModel));
			}
			for (Field custfield : custFields) {
				custfield.setAccessible(true);
				if (custplanfield.getName() == custfield.getName()) 
					custplanfield.set(cpmodel, custfield.get(custmodel));
			}
		}
		System.out.println(cpmodel);
		return cpmodel;
	}
	
	

}
