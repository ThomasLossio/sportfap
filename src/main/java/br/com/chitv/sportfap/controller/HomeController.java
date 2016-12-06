package br.com.chitv.sportfap.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class HomeController {
	public String irPaginaHome() {
		return "/secured/home.xhtml?faces-redirect=true";
	}

	public String irPaginaEventos() {
		return "/secured/views/eventos.jsf?faces-redirect=true";
	}

	public String irPaginaLogin() {
		return "/secured/views/login.jsf?faces-redirect=true";
	}

}