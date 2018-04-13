package de.kla.dsip.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

import de.kla.dsip.service.AlphaService;
import de.kla.dsip.service.BetaService;
import de.kla.dsip.service.GammaService;

@Configuration
public class ClientHttpInvoker {

	private static final String URL = "http://localhost:8090/";

	@Bean
	public HttpInvokerProxyFactoryBean alphaInvoker() {
		HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
		invoker.setServiceUrl(URL + "alpha");
		invoker.setServiceInterface(AlphaService.class);
		return invoker;
	}

	@Bean
	public HttpInvokerProxyFactoryBean betaInvoker() {
		HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
		invoker.setServiceUrl(URL + "beta");
		invoker.setServiceInterface(BetaService.class);
		return invoker;
	}

	@Bean
	public HttpInvokerProxyFactoryBean gammaInvoker() {
		HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
		invoker.setServiceUrl(URL + "gamma");
		invoker.setServiceInterface(GammaService.class);
		return invoker;
	}
}
