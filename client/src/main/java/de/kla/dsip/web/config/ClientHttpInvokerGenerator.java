package de.kla.dsip.web.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.stereotype.Component;

import de.kla.dsip.business.ServiceDefinitionProvider;
import de.kla.dsip.service.base.DsipService;

@Component
public class ClientHttpInvokerGenerator {

	public static final String URL = "http://localhost:8080/";

	private final ApplicationContext applicationContext;
	private final ServiceDefinitionProvider serviceDefinitionProvider;

	@Autowired
	public ClientHttpInvokerGenerator(ApplicationContext applicationContext,
			ServiceDefinitionProvider serviceDefinitionProvider) {
		this.applicationContext = applicationContext;
		this.serviceDefinitionProvider = serviceDefinitionProvider;
	}

	@PostConstruct
	public void init() {
		BeanDefinitionRegistry registry = (BeanDefinitionRegistry) applicationContext.getAutowireCapableBeanFactory();

		for (Class<? extends DsipService> service : serviceDefinitionProvider.dsipServicesManuel()) {
			String beanName = service.getSimpleName();
			String beanToFirstLower = beanName.substring(0, 1).toLowerCase() + beanName.substring(1);
			String serviceUrl = URL + service.getSimpleName();

			GenericBeanDefinition gbd = new GenericBeanDefinition();
			gbd.setBeanClass(HttpInvokerProxyFactoryBean.class);

			MutablePropertyValues mpv = new MutablePropertyValues();
			mpv.add("serviceInterface", service);
			mpv.add("serviceUrl", serviceUrl);

			gbd.setPropertyValues(mpv);

			registry.registerBeanDefinition(beanToFirstLower, gbd);
		}
	}
}
