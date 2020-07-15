package dummy.config;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;
import org.springframework.beans.factory.annotation.Autowired;

import dummy.entity.CallDetailsEntity;
import dummy.model.CallDetailsModel;

public class DTOConfigurer extends BeanMappingBuilder{
	
	@Autowired
	DozerBeanMapper mapper;

	@Override
	protected void configure() {
		mapping(CallDetailsEntity.class, CallDetailsModel.class, TypeMappingOptions.wildcard(false));
	}


}