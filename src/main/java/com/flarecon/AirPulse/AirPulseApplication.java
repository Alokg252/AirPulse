package com.flarecon.AirPulse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class AirPulseApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirPulseApplication.class, args);
		System.out.println(Constants.START_MESSAGE);
	}

}
