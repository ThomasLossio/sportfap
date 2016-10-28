package br.com.chitv.sportfap.dao;

<<<<<<< HEAD
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;


import br.com.chitv.sportfap.model.Usuario;
import br.com.chitv.sportfap.model.UsuarioProfile;


@Named
@Dependent
public class UsuarioDao {

	@PersistenceContext(unitName="sportfap")
	private EntityManager em;

	@Transactional
	public void excluir(Usuario usuario) {
		this.em.remove(this.em.contains(usuario) ? usuario : this.em.merge(usuario) );
	}

	public List<Usuario> listaUsuarios() {
		TypedQuery<Usuario> query = em.createQuery("select u from Usuario u", Usuario.class);
		return query.getResultList();
	}
	
	@Transactional
	public void salvar(Usuario usuario) {
		this.em.merge(usuario);
	}

	public void atualizar(Usuario usuario) {
		this.em.merge(usuario);
	}

	public Usuario findByNome(String nome) {
		String queryStr = "select u from Usuario u where u.nome = :nome";
		TypedQuery<Usuario> query = this.em.createQuery(queryStr, Usuario.class);
		query.setParameter("nome", nome);
		List<Usuario> usuarios = query.getResultList();
		return usuarios.isEmpty() ? null : usuarios.get(0);
	}
	public Usuario findByNomeFake(String nome) {
		Usuario usuario = new Usuario();
		usuario.setNome("ismael");
		usuario.setId(1L);
		
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(usuario);
		
		UsuarioProfile usuarioProfile = new UsuarioProfile();
		usuarioProfile.setId(1L);
		usuarioProfile.setType("ROLE_ADMIN");
		usuarioProfile.setUsuarios(usuarios);
		
		List<UsuarioProfile> usuarioProfiles = new ArrayList<UsuarioProfile>();
		usuarioProfiles.add(usuarioProfile);
		
	
		
		return usuario; 
	}

}
=======
=======
>>>>>>> 155509e7609f00a2520cc169990d14e076f7a69a

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
<<<<<<< HEAD
>>>>>>> branch 'master' of https://github.com/ThomasNeo/sportfap.git
=======
>>>>>>> 155509e7609f00a2520cc169990d14e076f7a69a
