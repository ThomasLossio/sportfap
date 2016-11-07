package br.com.chitv.sportfap.dao;

import java.util.ArrayList;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import br.com.chitv.sportfap.model.Jogador;


@Named
@Dependent
public class JogadorDao {


	@PersistenceContext(unitName="sportfap")
	private EntityManager em;

	@Transactional
	public void excluir(Jogador jogador) {
		this.em.remove(this.em.contains(jogador) ? jogador : this.em.merge(jogador) );
	}

	public List<Jogador> listaJogadores() {
		TypedQuery<Jogador> query = em.createQuery("select id, nome, semestre, curso, numero from sportfap.jogador", Jogador.class);
		return query.getResultList();
	}
	
	@Transactional
	public void salvar(Jogador jogador) {
		this.em.merge(jogador);
	}

	public void atualizar(Jogador jogador) {
		this.em.merge(jogador);
	}

	public Jogador findByNome(String nome) {
		String queryStr = "select u from Usuario u where u.nome = :nome";
		TypedQuery<Jogador> query = this.em.createQuery(queryStr, Jogador.class);
		query.setParameter("nome", nome);
		List<Jogador> jogadores = query.getResultList();
		return jogadores.isEmpty() ? null : jogadores.get(0);
	}
	
	//Esse método está funcionando perfeitamente, explicarei pessoalmente para as demais partes
	@Transactional
	public Jogador findById(Long id){
		String queryStr = "select u from Jogador u where u.id = :id";
		TypedQuery<Jogador> query = this.em.createQuery(queryStr, Jogador.class);
		query.setParameter("id", id);
		List<Jogador> jogadores = query.getResultList();
		return jogadores.isEmpty() ? null : jogadores.get(0);
	}
	
	public Jogador findByNomeFake(String nome) {
		Jogador jogador = new Jogador();
		jogador.setNome("ismael");
		jogador.setId(1L);
		
		
		List<Jogador> jogadores = new ArrayList<Jogador>();
		jogadores.add(jogador);
		
//		JogadorProfile jogadorProfile = new JogadorProfile();
//		jogadorProfile.setId(1L);
//		jogadorProfile.setType("ROLE_ADMIN");
//		jogadorProfile.setJogadores(jogadores);
//		
//		List<JogadorProfile> jogadorProfiles = new ArrayList<JogadorProfile>();
//		jogadorProfiles.add(jogadorProfile);
		
	
		
		return jogador; 
	}

}