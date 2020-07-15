package dummy.config;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;
import org.springframework.beans.factory.annotation.Autowired;

import dummy.entity.CustomerEntity;
import dummy.model.CustomerModel;

public class DTOConfigurer extends BeanMappingBuilder {
	
	@Autowired
	DozerBeanMapper mapper;

	@Override
	protected void configure() {
		mapping(CustomerEntity.class, CustomerModel.class, TypeMappingOptions.wildcard(false));
	}

}