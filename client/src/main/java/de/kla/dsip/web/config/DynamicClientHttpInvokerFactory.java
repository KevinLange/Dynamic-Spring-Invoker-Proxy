package de.kla.dsip.web.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

import de.kla.dsip.service.AlphaService;
import de.kla.dsip.service.BetaService;
import de.kla.dsip.service.GammaService;
import de.kla.dsip.service.base.DsipService;

public class DynamicClientHttpInvokerFactory {

	private final ApplicationContext context;

	public DynamicClientHttpInvokerFactory(ApplicationContext context) {
		this.context = context;
	}

	public void init() {
		List<Class<? extends DsipService>> services = dsipServicesManuel();
		AutowireCapableBeanFactory beanFactory = context.getAutowireCapableBeanFactory();
		AbstractAutowireCapableBeanFactory factoryImpl = (AbstractAutowireCapableBeanFactory) beanFactory;
		
		for (Class<? extends DsipService> service : services) {
			String serviceUrl = DynamicClientHttpInvokerConfiguration.URL + service.getSimpleName();

			HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
			invoker.setServiceUrl(serviceUrl);
			invoker.setServiceInterface(service);

			factoryImpl.registerSingleton(service.getSimpleName(), invoker);
		}
	}

	private List<Class<? extends DsipService>> dsipServicesManuel() {
		List<Class<? extends DsipService>> services = new ArrayList<>();

		services.add(AlphaService.class);
		services.add(BetaService.class);
		services.add(GammaService.class);

		return services;
	}

	private List<Class<? extends DsipService>> dsipServicesAutomatic() {
		List<Class<? extends DsipService>> services = new ArrayList<>();

		// TODO add automatically
		// https://github.com/google/guava
		// https://github.com/ronmamo/reflections

		return services;
	}
}