package dummy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.jms.annotation.EnableJms;


@SpringBootApplication
@EnableEurekaClient
@EnableCaching
@EnableJms
public class PlanMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanMsApplication.class, args);
	}

}
