package org.meditation.meditation_tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Meditation Tracker API", version = "1.0", description = "Meditation Tracker API", 
				contact = @Contact(name = "Harshith N J", email = "Harshith.dev2024@outlook.com")))		
public class MeditationTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeditationTrackerApplication.class, args);
	}

}
