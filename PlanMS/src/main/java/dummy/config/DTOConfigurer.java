package dummy.config;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;
import org.springframework.beans.factory.annotation.Autowired;

import dummy.entity.PlanEntity;
import dummy.model.PlanModel;

public class DTOConfigurer extends BeanMappingBuilder{

	@Autowired
	DozerBeanMapper mapper;

	@Override
	protected void configure() {
		mapping(PlanEntity.class, PlanModel.class, TypeMappingOptions.wildcard(false));
	}

}