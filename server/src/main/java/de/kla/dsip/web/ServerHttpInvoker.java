package de.kla.dsip.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

import de.kla.dsip.service.AlphaService;
import de.kla.dsip.service.BetaService;
import de.kla.dsip.service.GammaService;
import de.kla.dsip.service.impl.AlphaServiceImpl;
import de.kla.dsip.service.impl.BetaServiceImpl;
import de.kla.dsip.service.impl.GammaServiceImpl;

@Configuration
public class ServerHttpInvoker {

	@Bean(name = "/AlphaService")
	HttpInvokerServiceExporter alphaInvoker() {
		HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
		exporter.setService(new AlphaServiceImpl());
		exporter.setServiceInterface(AlphaService.class);
		return exporter;
	}

	@Bean(name = "/BetaService")
	HttpInvokerServiceExporter betaInvoker() {
		HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
		exporter.setService(new BetaServiceImpl());
		exporter.setServiceInterface(BetaService.class);
		return exporter;
	}
	
	@Bean(name = "/GammaService")
	HttpInvokerServiceExporter gammaInvoker() {
		HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
		exporter.setService(new GammaServiceImpl());
		exporter.setServiceInterface(GammaService.class);
		return exporter;
	}
}
