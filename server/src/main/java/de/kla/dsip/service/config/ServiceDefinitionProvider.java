package de.kla.dsip.service.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;
import org.springframework.stereotype.Component;

import de.kla.dsip.service.AlphaService;
import de.kla.dsip.service.BetaService;
import de.kla.dsip.service.GammaService;
import de.kla.dsip.service.base.DsipService;

@Component
public class ServiceDefinitionProvider {

	public List<ServiceDefinition> dsipServicesManuel() {
		List<ServiceDefinition> services = new ArrayList<>();

		services.add(new ServiceDefinition(AlphaService.class));
		services.add(new ServiceDefinition(BetaService.class));
		services.add(new ServiceDefinition(GammaService.class));

		return services;
	}

	/**
	 * Finds all services that have to be added to the spring context.<br>
	 * 
	 * @see https://github.com/ronmamo/reflections
	 * @return
	 */
	public Collection<ServiceDefinition> dsipServicesAutomatic() {
		Set<ServiceDefinition> services = new HashSet<>();

		Reflections reflections = new Reflections("de.kla.dsip");
		Set<Class<? extends DsipService>> subTypes = reflections.getSubTypesOf(DsipService.class);

		for (Class<? extends DsipService> subType : subTypes) {
			if (!subType.isInterface()) {
				// we only need the interfaces
				continue;
			}

			// TODO what about multiple interface extensions?
			services.add(new ServiceDefinition(subType));
		}

		return services;
	}
}
