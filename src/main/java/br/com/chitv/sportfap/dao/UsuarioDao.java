package br.com.chitv.sportfap.dao;


import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import br.com.chitv.sportfap.model.Usuario;

@Named
@Dependent
public class UsuarioDao{

	@PersistenceContext(unitName="sportfap")
	private EntityManager em;
	
	@Transactional
	public void salvar(Usuario usuario) {
		this.em.merge(usuario);
	}
}
