package com.codehacks.whatsappclone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WhatsAppCloneApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhatsAppCloneApiApplication.class, args);
	}

}
