package de.kla.dsip.service.impl;

import org.springframework.stereotype.Component;

import de.kla.dsip.service.AlphaService;

@Component
public class AlphaServiceImpl implements AlphaService{

	@Override
	public void call() {
		System.out.println("AlphaServiceImpl called");
	}
}