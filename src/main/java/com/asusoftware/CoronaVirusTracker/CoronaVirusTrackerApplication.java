package com.asusoftware.CoronaVirusTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // Permit to work with Scheduling annotation
public class CoronaVirusTrackerApplication {

	public static void main(String[] args) {
		String ENV_PORT = System.getenv().get("PORT");
		String ENV_DYNO = System.getenv().get("DYNO");
		if(ENV_PORT != null && ENV_DYNO != null) {
			System.getProperties().put("server.port", ENV_PORT);
		}

		SpringApplication.run(CoronaVirusTrackerApplication.class, args);
	}

}
