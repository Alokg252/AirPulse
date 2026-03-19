package com.flarecon.AirPulse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AirPulseApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirPulseApplication.class, args);
		System.out.println("Pulse Is High !!!");
	}

}
