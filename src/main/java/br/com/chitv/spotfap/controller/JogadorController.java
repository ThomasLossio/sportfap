package br.com.chitv.spotfap.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.chitv.spotfap.dao.JogadorDao;
import br.com.chitv.spotfap.model.Jogador;


@Named
@RequestScoped
public class JogadorController implements Serializable {

	private static final long serialVersionUID = 5202799275364383072L;

	private Jogador jogador;

	private List<Jogador> listaJogadores;

	@Inject
	private JogadorDao JogadorDao;

	@PostConstruct
	public void init() {
		this.jogador = new Jogador();
	}

	public List<Jogador> getJogadores() {
		if (this.listaJogadores == null || this.listaJogadores.isEmpty()) {
			this.listaJogadores = this.JogadorDao.listaJogadores();
		}
		return this.listaJogadores;
	}


	public String excluir() {
		this.JogadorDao.excluir(this.jogador);
		this.listaJogadores = JogadorDao.listaJogadores();
		this.jogador = new Jogador();
		return "index?faces-redirect=true";
	}

	public String irPaginaAtualizar(Jogador jogador) {
		this.jogador = jogador;
		return "jogador/atualizar";
	}

	public String irPaginaSalvar() {
		return "jogador/cadastrar?faces-redirect=true";
	}

	@Transactional
	public String atualizar() {
		this.JogadorDao.atualizar(this.jogador);
		this.jogador = new Jogador();
		return "../index";
	}

	public String salvar() {
		this.JogadorDao.salvar(this.jogador);
		this.listaJogadores = JogadorDao.listaJogadores();
		this.jogador = new Jogador();
		return "../index";
	}

	public String voltar() {
		return "/index?faces-redirect=true";
	}

	public List<Jogador> getlistaJogadores() {
		return listaJogadores;
	}

	public void setlistaJogadores(List<Jogador> listaJogadores) {
		this.listaJogadores = listaJogadores;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
	
}