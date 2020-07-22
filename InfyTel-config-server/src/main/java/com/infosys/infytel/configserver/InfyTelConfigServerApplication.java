package com.infosys.infytel.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class InfyTelConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfyTelConfigServerApplication.class, args);
	}

}
