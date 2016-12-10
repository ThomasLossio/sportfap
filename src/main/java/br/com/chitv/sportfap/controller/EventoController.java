package br.com.chitv.sportfap.controller;

import java.io.Serializable;
import java.util.List;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import org.primefaces.model.UploadedFile;

import org.primefaces.context.RequestContext;


import br.com.chitv.sportfap.dao.EventoDao;
import br.com.chitv.sportfap.model.Arquivo;
import br.com.chitv.sportfap.model.Evento;


@Named
@RequestScoped
public class EventoController implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3288870853461444768L;

	private Evento evento;

	private List<Evento> eventos;

	@Inject
	private EventoDao eventoDao;

	@PostConstruct
	public void init() {
		this.evento = new Evento();
	}

	public List<Evento> getUsuarios() {
		if (this.eventos == null || this.eventos.isEmpty()) {
			this.eventos = this.eventoDao.listaEventos();
		}
		return this.eventos;
	}


	public String excluir() {
		this.eventoDao.excluir(this.evento);
		this.eventos = eventoDao.listaEventos();
		this.evento = new Evento();
		return "index?faces-redirect=true";
	}

	public String irPaginaAtualizar(Evento evento) {
		this.evento = evento;
		return "usuario/atualizar";
	}

	public String irPaginaSalvar() {
		return "usuario/cadastrar?faces-redirect=true";
	}

	@Transactional
	public String atualizar() {
		this.eventoDao.atualizar(this.evento);
		this.evento = new Evento();
		return "../index.xhtml";
	}
	public String irPaginaTimes() {
		return "../secured/views/admin/index.xhtml";
	}

	public String salvar() {
		this.evento.setArquivo(new Arquivo(this.file != null ? this.file.getContents() : null));
		this.eventoDao.salvar(this.evento);
		this.eventos = eventoDao.listaEventos();
		this.evento = new Evento();
		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Time Cadastrado Com Sucesso!"));
		 RequestContext.getCurrentInstance().reset("cadastrarTimeForm:panel");
		 return null;
	}

	public String voltar() {
		return "/secured/views/admin/index?faces-redirect=true";
	}

	public List<Evento> getlistaEventos() {
		return eventos;
	}

	public void setlistaTimes(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setTime(Evento evento) {
		this.evento = evento;
	}
	
	private UploadedFile file;
    
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
     
    public void upload() {
        if(file != null) {
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
	

}
