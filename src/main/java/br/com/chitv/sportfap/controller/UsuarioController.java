package br.com.chitv.sportfap.controller;

import java.io.Serializable;
<<<<<<< HEAD
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.primefaces.context.RequestContext;


import br.com.chitv.sportfap.dao.UsuarioDao;
import br.com.chitv.sportfap.model.Usuario;


@Named
@RequestScoped
public class UsuarioController implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -1638290532499587239L;

	private Usuario usuario;

	private List<Usuario> usuarios;

	@Inject
	private UsuarioDao usuarioDao;

	@PostConstruct
	public void init() {
		this.usuario = new Usuario();
	}

	public List<Usuario> getUsuarios() {
		if (this.usuarios == null || this.usuarios.isEmpty()) {
			this.usuarios = this.usuarioDao.listaUsuarios();
		}
		return this.usuarios;
	}


	public String excluir() {
		this.usuarioDao.excluir(this.usuario);
		this.usuarios = usuarioDao.listaUsuarios();
		this.usuario = new Usuario();
		return "index?faces-redirect=true";
	}

	public String irPaginaAtualizar(Usuario usuario) {
		this.usuario = usuario;
		return "usuario/atualizar";
	}

	public String irPaginaSalvar() {
		return "usuario/cadastrar?faces-redirect=true";
	}

	@Transactional
	public String atualizar() {
		this.usuarioDao.atualizar(this.usuario);
		this.usuario = new Usuario();
		return "../index.xhtml";
	}
	public String irPaginaUsuarios() {
		return "../secured/views/admin/index.xhtml";
	}

	public String salvar() {
		this.usuarioDao.salvar(this.usuario);
		this.usuarios = usuarioDao.listaUsuarios();
		this.usuario = new Usuario();
		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Usuario Cadastrado Com Sucesso!"));
		 RequestContext.getCurrentInstance().reset("cadastrarTimeForm:panel");
		 return null;
	}

	public String voltar() {
		return "/secured/views/admin/index?faces-redirect=true";
	}

	public List<Usuario> getlistaUsuarios() {
		return usuarios;
	}

	public void setlistaUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setJogador(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
=======

public class UsuarioController implements Serializable{
	
}
>>>>>>> branch 'master' of https://github.com/ThomasNeo/sportfap.git
