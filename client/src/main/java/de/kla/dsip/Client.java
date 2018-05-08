package de.kla.dsip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import de.kla.dsip.web.config.ClientHttpInvokerGenerator;

@ComponentScan
@EnableAutoConfiguration
public class Client {

	/**
	 * Is not directly used but the postConstruct created the dynamic HttpInvoker
	 */
	@Autowired
	@SuppressWarnings("unused")
	private ClientHttpInvokerGenerator generatorBeanDef;

	public static void main(String[] args) {
		SpringApplication.run(Client.class, args);
	}
}
