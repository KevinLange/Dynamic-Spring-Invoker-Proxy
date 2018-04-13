package de.kla.dsip.service.impl;

import org.springframework.stereotype.Component;

import de.kla.dsip.service.GammaService;

@Component
public class GammaServiceImpl implements GammaService {

	@Override
	public void call() {
		System.out.println("GammaServiceImpl called");
	}
}
