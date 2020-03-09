package dummy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CallDetailsMs1Application {

	public static void main(String[] args) {
		SpringApplication.run(CallDetailsMs1Application.class, args);
	}

}
