package de.kla.dsip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class Client {

	public static void main(String[] args) {
		SpringApplication.run(Client.class, args);
	}
}
