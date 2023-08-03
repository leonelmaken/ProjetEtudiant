package com.mono.pjdepartement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.mono.pjdepartement.controller", "com.mono.pjdepartement.entity", "com.mono.pjdepartement.entity.app", "com.mono.pjdepartement.entity.metier", "com.mono.pjdepartement.entity.repository", "com.mono.pjdepartement.service", "com.mono.pjdepartement.service.implement"})
public class PjDepartementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PjDepartementApplication.class, args);
	}

}
