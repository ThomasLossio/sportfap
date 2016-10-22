package br.com.chitv.sportfap.security;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.chitv.sportfap.dao.*;
import br.com.chitv.sportfap.model.*;

@Named
@RequestScoped
public class CustomJogadorDetailsService implements JogadorDetailsService {

	@Inject
	private JogadorDao jogadorDao;

	public JogadorDetails loadJogadorByUJogadorname(String nome) throws JogadornameNotFoundException {

		Jogador jogador = jogadorDao.findByNomeFake(nome);

		if (jogador == null) {
			throw new JogadornameNotFoundException("Jogador not found");
		}
		
		List<SimpleGrantedAuthority> authorityList = new ArrayList<SimpleGrantedAuthority>();

		List<JogadorProfile> profiles = jogador.getJogadorProfiles();

		for (JogadorProfile profile : profiles) {
			authorityList.add(new SimpleGrantedAuthority(profile.getType()));
		}
		
		return new CustomJogadorDetails(jogador, authorityList);

	}
	
}