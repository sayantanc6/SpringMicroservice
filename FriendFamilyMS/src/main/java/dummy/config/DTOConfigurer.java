package dummy.config;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;
import org.springframework.beans.factory.annotation.Autowired;

import dummy.entity.FriendFamilyEntity;
import dummy.model.FriendFamilyModel;

public class DTOConfigurer extends BeanMappingBuilder{

	@Autowired
	DozerBeanMapper mapper;

	@Override
	protected void configure() {
		mapping(FriendFamilyEntity.class, FriendFamilyModel.class, TypeMappingOptions.wildcard(false));
	}

}