package de.kla.dsip.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import de.kla.dsip.service.AlphaService;
import de.kla.dsip.service.BetaService;
import de.kla.dsip.service.GammaService;
import de.kla.dsip.service.base.DsipService;

@Component
public class ServiceDefinitionProvider {

	public List<Class<? extends DsipService>> dsipServicesManuel() {
		List<Class<? extends DsipService>> services = new ArrayList<>();

		services.add(AlphaService.class);
		services.add(BetaService.class);
		services.add(GammaService.class);

		return services;
	}

	public List<Class<? extends DsipService>> dsipServicesAutomatic() {
		List<Class<? extends DsipService>> services = new ArrayList<>();

		// TODO add automatically
		// https://github.com/google/guava
		// https://github.com/ronmamo/reflections

		return services;
	}
}
