package de.kla.dsip.service.impl;

import org.springframework.stereotype.Component;

import de.kla.dsip.service.BetaService;

@Component
public class BetaServiceImpl implements BetaService {

	@Override
	public void call() {
		System.out.println("GammaServiceImpl called");
	}
}
