package de.kla.dsip.web.config.manual;

import org.springframework.context.annotation.Bean;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

import de.kla.dsip.service.AlphaService;
import de.kla.dsip.service.BetaService;
import de.kla.dsip.service.GammaService;

//@Configuration
public class ClientHttpInvoker {

	private static final String URL = "http://localhost:8080/";

	@Bean
	public HttpInvokerProxyFactoryBean alphaInvoker() {
		HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
		invoker.setServiceUrl(URL + AlphaService.class.getSimpleName());
		invoker.setServiceInterface(AlphaService.class);
		return invoker;
	}

	@Bean
	public HttpInvokerProxyFactoryBean betaInvoker() {
		HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
		invoker.setServiceUrl(URL + BetaService.class.getSimpleName());
		invoker.setServiceInterface(BetaService.class);
		return invoker;
	}

	@Bean
	public HttpInvokerProxyFactoryBean gammaInvoker() {
		HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
		invoker.setServiceUrl(URL + GammaService.class.getSimpleName());
		invoker.setServiceInterface(GammaService.class);
		return invoker;
	}
}
