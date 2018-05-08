package de.kla.dsip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import de.kla.dsip.web.config.ServerHttpInvokerGenerator;

@ComponentScan
@EnableAutoConfiguration
public class Server {

	/**
	 * Is not directly used but the postConstruct created the dynamic HttpInvoker
	 */
	@Autowired
	@SuppressWarnings("unused")
	private ServerHttpInvokerGenerator serverHttpInvokerGenerator;

	public static void main(String[] args) {
		SpringApplication.run(Server.class, args);
	}
}
