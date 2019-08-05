package io.java.brain.MovieCatelogService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient
public class MovieCatelogServiceApplication {
	
	    //it is a singleton class which return single instance of this object.
	         //@Bean working as a producer which is use to injact in any class by @Autowored
	@Bean
	@LoadBalanced//call service discovery every time and consume the services//doing client side service discovery
	public RestTemplate getTemplate()
	{
		return new RestTemplate();
		
	}
	
	@Bean//give asychronus call it is belong to reactive Progrraming
	
	public WebClient.Builder getWebclientBuilder()
	{
		return WebClient.builder();
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieCatelogServiceApplication.class, args);
	}

}
