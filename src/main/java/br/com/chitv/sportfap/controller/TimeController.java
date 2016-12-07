package br.com.chitv.sportfap.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.primefaces.context.RequestContext;

import br.com.chitv.sportfap.dao.TimeDao;
import br.com.chitv.sportfap.model.Jogador;
import br.com.chitv.sportfap.model.Time;

@Named
@RequestScoped
public class TimeController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3288870853461444768L;

	private Time time;
	private List<Time> times;

	@Inject
	private TimeDao timeDao;

	@PostConstruct
	public void init() {
		this.time = new Time();
	}

	public List<Time> getTimes() {
		if (this.times == null || this.times.isEmpty()) {
			this.times = this.timeDao.listaTimes();
		}
		return this.times;
	}

	public String excluir() {
		this.timeDao.excluir(this.time);
		this.times = timeDao.listaTimes();
		this.time = new Time();
		return "index?faces-redirect=true";
	}

	public String irPaginaAtualizar(Time time) {
		this.time = time;
		return "usuario/atualizar";
	}

	public String irPaginaSalvar() {
		return "usuario/cadastrar?faces-redirect=true";
	}

	@Transactional
	public String atualizar() {
		this.timeDao.atualizar(this.time);
		this.time = new Time();
		return "../index.xhtml";
	}

	public String irPaginaTimes() {
		return "../secured/views/admin/index.xhtml";
	}

	public String salvar() {
		this.timeDao.salvar(this.time);
		this.times = timeDao.listaTimes();
		this.time = new Time();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Time Cadastrado Com Sucesso!"));
		RequestContext.getCurrentInstance().reset("cadastrarTimeForm:panel");
		return null;
	}

	public String voltar() {
		return "/secured/views/admin/index?faces-redirect=true";
	}

	public List<Time> getlistaTimes() {
		return times;
	}

	public void setlistaTimes(List<Time> times) {
		this.times = times;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

}
