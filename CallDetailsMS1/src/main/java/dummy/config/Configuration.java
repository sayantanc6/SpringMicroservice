package dummy.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {
	
	@Bean
	public DozerBeanMapper mapper() {
	    return new DozerBeanMapper();
	}

}