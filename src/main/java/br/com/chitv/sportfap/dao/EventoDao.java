package br.com.chitv.sportfap.dao;

import java.util.ArrayList;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import br.com.chitv.sportfap.model.Evento;


@Named
@Dependent
public class EventoDao {


	@PersistenceContext(unitName="sportfap")
	private EntityManager em;

	@Transactional
	public void excluir(Evento evento) {
		this.em.remove(this.em.contains(evento) ? evento : this.em.merge(evento) );
	}

	public List<Evento> listaEventos() {
		TypedQuery<Evento> query = em.createQuery("select u from Evento u", Evento.class);
		return query.getResultList();
	}
	
	@Transactional
	public void salvar(Evento evento) {
		this.em.merge(evento);
	}

	public void atualizar(Evento evento) {
		this.em.merge(evento);
	}
	
	@Transactional
	public Evento findById(Long id){
		String queryStr = "select u from Evento u where u.id = :id";
		TypedQuery<Evento> query = this.em.createQuery(queryStr, Evento.class);
		query.setParameter("id", id);
		List<Evento> eventos = query.getResultList();
		return eventos.isEmpty() ? null : eventos.get(0);
	}
	


}