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

	@Autowired
	public ServerHttpInvokerGenerator(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@PostConstruct
	public void init() {
		BeanDefinitionRegistry registry = (BeanDefinitionRegistry) applicationContext.getAutowireCapableBeanFactory();

		for (ServiceDefinition serviceDefinition : ServiceDefinitionProvider.dsipServices()) {
			GenericBeanDefinition gbd = new GenericBeanDefinition();
			gbd.setBeanClass(HttpInvokerServiceExporter.class);

			MutablePropertyValues mpv = new MutablePropertyValues();
			mpv.add("service", applicationContext.getBean(serviceDefinition.getServiceInterface()));
			mpv.add("serviceInterface", serviceDefinition.getServiceInterface());

			gbd.setPropertyValues(mpv);

			registry.registerBeanDefinition("/" + serviceDefinition.getBeanName(), gbd);
		}
	}
}
