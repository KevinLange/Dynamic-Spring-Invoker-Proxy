package de.kla.dsip.web.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.stereotype.Component;

import de.kla.dsip.service.config.ServiceDefinition;
import de.kla.dsip.service.config.ServiceDefinitionProvider;

@Component
public class ServerHttpInvokerGenerator {

	private final ApplicationContext applicationContext;
	private final ServiceDefinitionProvider serviceDefinitionProvider;

	@Autowired
	public ServerHttpInvokerGenerator(ApplicationContext applicationContext,
			ServiceDefinitionProvider serviceDefinitionProvider) {
		this.applicationContext = applicationContext;
		this.serviceDefinitionProvider = serviceDefinitionProvider;
	}

	@PostConstruct
	public void init() {
		BeanDefinitionRegistry registry = (BeanDefinitionRegistry) applicationContext.getAutowireCapableBeanFactory();

		for (ServiceDefinition serviceDefinition : serviceDefinitionProvider.dsipServicesManuel()) {
			String beanName = serviceDefinition.getServiceInterface().getSimpleName();

			GenericBeanDefinition gbd = new GenericBeanDefinition();
			gbd.setBeanClass(HttpInvokerServiceExporter.class);

			MutablePropertyValues mpv = new MutablePropertyValues();
			mpv.add("service", serviceDefinition.getService());
			mpv.add("serviceInterface", serviceDefinition.getServiceInterface());

			gbd.setPropertyValues(mpv);

			registry.registerBeanDefinition(beanName, gbd);
		}
	}
}
