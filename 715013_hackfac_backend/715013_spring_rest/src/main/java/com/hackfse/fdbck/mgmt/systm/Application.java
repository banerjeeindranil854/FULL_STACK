package com.hackfse.fdbck.mgmt.systm;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
	
	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
	
	public static void main(String[] args) {
		System.setProperty("data.dir", "G:\\");
		System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
		SpringApplication.run(Application.class, args);
	}
}
