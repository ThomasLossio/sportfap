package br.com.chitv.sportfap.security;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import br.com.chitv.sportfap.model.Jogador;


public class CustomJogadorDetails extends org.springframework.security.core.jogadordetails.Jogador {

	private static final long serialVersionUID = 1L;
	private Jogador jogador;

	public CustomJogadorDetails(Jogador jogador, List<? extends GrantedAuthority> authorityList) {
		super(jogador.getNome(), jogador.getNumero(), jogador.getSemestre(), jogador.getCurso(), authorityList);
		this.jogador = jogador;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setUser(Jogador jogador) {
		this.jogador = jogador;
	}

}