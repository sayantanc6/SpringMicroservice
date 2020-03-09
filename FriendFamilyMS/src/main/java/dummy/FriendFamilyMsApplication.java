package dummy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FriendFamilyMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FriendFamilyMsApplication.class, args);
	}

}
