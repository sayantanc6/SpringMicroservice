package com.infosys.infytel.calldetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient 
@SpringBootApplication
public class InfyTelCalldetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfyTelCalldetailsApplication.class, args);
	}

}
