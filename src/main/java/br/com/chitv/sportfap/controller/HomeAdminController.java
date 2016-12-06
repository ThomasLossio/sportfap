package br.com.chitv.sportfap.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class HomeAdminController {
	public String irPaginaHomeAdmin() {
		return "/secured/views/admin/index.xhtml?faces-redirect=true";
	}

	public String irPaginaEventosAdmin() {
		return "/secured/views/admin/eventos/evento.xhtml?faces-redirect=true";
	}
	public String irPaginaTimeAdmin() {
		return "/secured/views/admin/time/cadastrar.xhtml?faces-redirect=true";
	}
}
