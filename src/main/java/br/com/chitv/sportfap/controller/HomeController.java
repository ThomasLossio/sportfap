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
		return "/secured/home.jsf?faces-redirect=true";
	}
	
	public String irPaginaHomeAdmin() {
		return "/secured/views/admin/index.xhtml.jsf?faces-redirect=true";
	}

	public String irPaginaEventos(){
		return "/secured/views/eventos.xhtml?faces-redirect=true";
	}
	public String irPaginaEventosAdmin(){
		return "/secured/views/admin/eventos/eventos.xhtml?faces-redirect=true";
	}
	public String irPaginaTimeAdmin() {
		return "/secured/views/admin/time/testeCadastroTime.xhtml?faces-redirect=true";
	}
	
}