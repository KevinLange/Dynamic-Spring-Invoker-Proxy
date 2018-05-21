package de.kla.dsip.web.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.stereotype.Component;

import de.kla.dsip.service.config.ServiceDefinition;
import de.kla.dsip.service.config.ServiceDefinitionProvider;

@Component
public class ClientHttpInvokerGenerator {

	public static final String URL = "http://localhost:8080/";

	private final ApplicationContext applicationContext;

	@Autowired
	public ClientHttpInvokerGenerator(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@PostConstruct
	public void init() {
		BeanDefinitionRegistry registry = (BeanDefinitionRegistry) applicationContext.getAutowireCapableBeanFactory();

		for (ServiceDefinition serviceDefinition : ServiceDefinitionProvider.dsipServices()) {
			String serviceUrl = URL + serviceDefinition.getBeanName();

			GenericBeanDefinition gbd = new GenericBeanDefinition();
			gbd.setBeanClass(HttpInvokerProxyFactoryBean.class);

			MutablePropertyValues mpv = new MutablePropertyValues();
			mpv.add("serviceInterface", serviceDefinition.getServiceInterface());
			mpv.add("serviceUrl", serviceUrl);

			gbd.setPropertyValues(mpv);

			registry.registerBeanDefinition(serviceDefinition.getBeanName(), gbd);
		}
	}
}
