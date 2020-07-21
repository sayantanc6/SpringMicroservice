package com.infosys.infytel.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin2.server.internal.EnableZipkinServer;

@EnableZipkinServer
@SpringBootApplication
public class InfyTelZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfyTelZipkinApplication.class, args);
	}

}
