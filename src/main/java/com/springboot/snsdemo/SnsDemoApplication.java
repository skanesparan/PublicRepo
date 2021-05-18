package com.springboot.snsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextInstanceDataAutoConfiguration;
import org.springframework.cloud.aws.autoconfigure.context.ContextRegionProviderAutoConfiguration;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;

@SpringBootApplication(exclude = { ContextInstanceDataAutoConfiguration.class,
		ContextRegionProviderAutoConfiguration.class, ContextStackAutoConfiguration.class })
public class SnsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnsDemoApplication.class, args);
	}

}
