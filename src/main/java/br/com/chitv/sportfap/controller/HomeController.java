package br.com.chitv.sportfap.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class HomeController {

	private String sportfap = "Teste!";

	public String getsportfap() {
		return sportfap;
	}

	public void setsportfap(String sportfap) {
		this.sportfap = sportfap;
	}

	public String irPaginaHome() {
		return "home?redirect-true";
	}
}