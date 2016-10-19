package br.com.chitv.spotfap.controller;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

@Named
@RequestScoped
public class Controller implements Serializable{
	
	private static final long serialVersionUID = -8391472676388527662L;

	@Transactional
	public String irPagina(String link) {
		return "/" + link + ".xhtml";
	}
	
}
