package de.kla.dsip.service.config;

import de.kla.dsip.service.base.DsipService;

public class ServiceDefinition {

	private final Class<? extends DsipService> serviceInterface;
	private final String beanName;

	/**
	 * Uses the default name of a spring bean provided by
	 * {@link #getDefaultBeanName(Class)}
	 * 
	 * @param serviceInterface
	 */
	public ServiceDefinition(Class<? extends DsipService> serviceInterface) {
		this(serviceInterface, getDefaultBeanName(serviceInterface));
	}

	/**
	 * Use this constructor if the service has an specific name. Otherwise use the
	 * constructor without second parameter.
	 * 
	 * @param serviceInterface
	 * @param beanName
	 */
	public ServiceDefinition(Class<? extends DsipService> serviceInterface, String beanName) {
		this.serviceInterface = serviceInterface;
		this.beanName = beanName;

	}

	public Class<? extends DsipService> getServiceInterface() {
		return serviceInterface;
	}

	public String getBeanName() {
		return beanName;
	}

	/**
	 * Returns the name of the service interface with first letter in lower case.
	 * 
	 * @return the spring name of a bean
	 */
	private static String getDefaultBeanName(Class<? extends DsipService> serviceInterface) {
		String serviceName = serviceInterface.getSimpleName();
		return serviceName.substring(0, 1).toLowerCase() + serviceName.substring(1);
	}

	@Override
	public String toString() {
		return "ServiceDefinition [serviceInterface=" + serviceInterface + ", beanName=" + beanName + "]";
	}
}
