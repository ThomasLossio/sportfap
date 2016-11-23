package br.com.chitv.sportfap.dao;

import java.util.ArrayList;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import br.com.chitv.sportfap.model.Time;


@Named
@Dependent
public class TimeDao {


	@PersistenceContext(unitName="sportfap")
	private EntityManager em;

	@Transactional
	public void excluir(Time time) {
		this.em.remove(this.em.contains(time) ? time : this.em.merge(time) );
	}

	public List<Time> listaTimes() {
		TypedQuery<Time> query = em.createQuery("select u from Time u", Time.class);
		return query.getResultList();
	}
	
	@Transactional
	public void salvar(Time time) {
		this.em.merge(time);
	}

	public void atualizar(Time time) {
		this.em.merge(time);
	}

/*	public Jogador findByNome(String nome) {
		String queryStr = "select u from Usuario u where u.nome = :nome";
		TypedQuery<Jogador> query = this.em.createQuery(queryStr, Jogador.class);
		query.setParameter("nome", nome);
		List<Jogador> jogadores = query.getResultList();
		return jogadores.isEmpty() ? null : jogadores.get(0);
	}
*/	
	
	//Esse método está funcionando perfeitamente, explicarei pessoalmente para as demais partes
	@Transactional
	public Time findById(Long id){
		String queryStr = "select u from Jogador u where u.id = :id";
		TypedQuery<Time> query = this.em.createQuery(queryStr, Time.class);
		query.setParameter("id", id);
		List<Time> times = query.getResultList();
		return times.isEmpty() ? null : times.get(0);
	}
	


}