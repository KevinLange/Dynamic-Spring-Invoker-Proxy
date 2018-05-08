package de.kla.dsip.web;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;

import de.kla.dsip.service.AlphaService;
import de.kla.dsip.service.BetaService;
import de.kla.dsip.service.GammaService;

@Controller
public class ClientController {

	private final AlphaService alphaService;
	private final BetaService betaService;
	private final GammaService gammaService;

	@Autowired
	public ClientController(AlphaService alphaService, BetaService betaService, GammaService gammaService) {
		Assert.notNull(alphaService, "alphaService must not be null");
		Assert.notNull(betaService, "betaService must not be null");
		Assert.notNull(gammaService, "gammaService must not be null");

		this.alphaService = alphaService;
		this.betaService = betaService;
		this.gammaService = gammaService;
	}

	@PostConstruct
	public void init() {
		alphaService.call();
		betaService.call();
		gammaService.call();
	}
}
