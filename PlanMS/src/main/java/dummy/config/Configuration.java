package dummy.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {
       @Bean
    public Queue queue(){
        return new ActiveMQQueue("test-queue");
    }
	
	@Bean
	public DozerBeanMapper mapper() {
	    return new DozerBeanMapper();
	}

        @Bean
	public JmsListenerContainerFactory<?> myFactory(
	    ConnectionFactory connectionFactory,
	    DefaultJmsListenerContainerFactoryConfigurer configurer) {
	  DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();

	  factory.setErrorHandler(t -> System.err.println("An error has occurred in the transaction"));

	  configurer.configure(factory, connectionFactory);
	  return factory;
	}
}
