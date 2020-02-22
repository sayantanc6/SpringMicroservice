package com.example.demo;

import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.annotation.MessageEndpoint;

@EnableBinding(Sink.class)
@MessageEndpoint
public class Consumer {
	
	@StreamListener(Sink.INPUT) 
	public void Consume(Employee emp) {
		System.out.println("in Consumer:"+emp.toString());
	}
	
}
