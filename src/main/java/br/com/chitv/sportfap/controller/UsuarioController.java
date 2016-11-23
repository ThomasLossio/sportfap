package br.com.chitv.sportfap.controller;

import java.awt.event.ActionEvent;
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

import br.com.chitv.sportfap.dao.UsuarioDao;
import br.com.chitv.sportfap.model.Usuario;

@Named
@RequestScoped
public class UsuarioController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3288870853461444768L;

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
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Usuario Cadastrado Com Sucesso!"));
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

	public String Checa() {
		boolean cert = usuarioDao.findByNomeSenha(usuario.getNome(), usuario.getSenha());
		if (cert) {
			return "logado.xhtml";
		} else {
			return "erro.xhtml";
		}

	}
	 public void login(ActionEvent event) {
	        RequestContext context = RequestContext.getCurrentInstance();
	        FacesMessage message = null;
	        boolean loggedIn = false;
	         
	        if(usuario.getNome() != null && usuario.getNome().equals("admin") && usuario.getSenha() != null && usuario.getSenha().equals("admin")) {
	            loggedIn = true;
	            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", usuario.getNome());
	        } else {
	            loggedIn = false;
	            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao logar", "Credenciais Invalida");
	        }
	         
	        FacesContext.getCurrentInstance().addMessage(null, message);
	        context.addCallbackParam("loggedIn", loggedIn);
	    }   
	
}
