package com.example.demo;

import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(Source.class)
@EnableScheduling
public class Producer {
	private  Source source;
	private Employee emp;
	
	@Scheduled(fixedRate = 10000)
	public void Produce() {
		emp = new Employee("john","doe","abc@example.com");
		for (int i = 0; i < 2; i++) {
			this.source.output().send(MessageBuilder.withPayload(emp).build());
		}
	}
}
