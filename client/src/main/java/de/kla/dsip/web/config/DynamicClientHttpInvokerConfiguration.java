package de.kla.dsip.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamicClientHttpInvokerConfiguration {

	public static final String URL = "http://localhost:8080/";

	public static final String BEAN_NAME = "httpInvokerProxyFactoryBean";

	private final ApplicationContext context;

	@Autowired
	public DynamicClientHttpInvokerConfiguration(ApplicationContext context) {
		this.context = context;
	}

	@Bean
	public DynamicClientHttpInvokerFactory dsipService() {
		DynamicClientHttpInvokerFactory invokerFactory = new DynamicClientHttpInvokerFactory(context);
		invokerFactory.init();
		return invokerFactory;
	}
}