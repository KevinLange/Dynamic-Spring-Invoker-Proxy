package de.kla.dsip.service.config;

import de.kla.dsip.service.base.DsipService;

public class ServiceDefinition {

	private Class<? extends DsipService> service;
	private Class<? extends DsipService> serviceInterface;

	public ServiceDefinition(Class<? extends DsipService> service, Class<? extends DsipService> serviceInterface) {
		this.service = service;
		this.serviceInterface = serviceInterface;
	}
	
	public Class<? extends DsipService> getService() {
		return service;
	}
	
	public Class<? extends DsipService> getServiceInterface() {
		return serviceInterface;
	}
}
