package de.kla.dsip.service.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import de.kla.dsip.service.AlphaService;
import de.kla.dsip.service.BetaService;
import de.kla.dsip.service.GammaService;
import de.kla.dsip.service.impl.AlphaServiceImpl;
import de.kla.dsip.service.impl.BetaServiceImpl;
import de.kla.dsip.service.impl.GammaServiceImpl;

@Component
public class ServiceDefinitionProvider {

	public List<ServiceDefinition> dsipServicesManuel() {
		List<ServiceDefinition> services = new ArrayList<>();

		services.add(new ServiceDefinition(AlphaServiceImpl.class, AlphaService.class));
		services.add(new ServiceDefinition(BetaServiceImpl.class, BetaService.class));
		services.add(new ServiceDefinition(GammaServiceImpl.class, GammaService.class));

		return services;
	}

	public List<ServiceDefinition> dsipServicesAutomatic() {
		List<ServiceDefinition> services = new ArrayList<>();

		// TODO add automatically
		// https://github.com/google/guava
		// https://github.com/ronmamo/reflections

		return services;
	}
}
