package com.springboot.snsdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;

@RestController
public class SNSController {

	@Autowired
	AmazonSNSClient amazonSNSClient;
	
	@Value("${cloud.aws.arn.url}")
	private String snsArn;
	
	@GetMapping("/subscribe/{id}")
	public String addSubscriber(@PathVariable("id") String emailId) {
		SubscribeRequest request = new SubscribeRequest(snsArn, "email", emailId);
		amazonSNSClient.subscribe(request);
		return "Successfully subscribed";
	}
	
	@GetMapping("/publish")
	public String publishMessage() {
		PublishRequest request = new PublishRequest(snsArn, "First Message", "My Body");
		amazonSNSClient.publish(request);
		return "Successfully published";
	}
	

}
