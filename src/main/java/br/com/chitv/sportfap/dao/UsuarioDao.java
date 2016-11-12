package br.com.chitv.sportfap.dao;





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
	private EntityManager emM;

	@Transactional
	public void excluir(Usuario usuario) {
		this.emM.remove(this.emM.contains(usuario) ? usuario : this.emM.merge(usuario) );
	}

	
	public List<Usuario> listaUsuarios() {
		TypedQuery<Usuario> query = emM.createQuery("select u from Usuario u", Usuario.class);
		return query.getResultList();
	}
	
	@Transactional
	public void salvar(Usuario usuario) {
		this.emM.merge(usuario);
	}

	public void atualizar(Usuario usuario) {
		this.emM.merge(usuario);
	}

	public Usuario findByNome(String nome) {
		String queryStr = "select u from Usuario u where u.nome = :nome";
		TypedQuery<Usuario> query = this.emM.createQuery(queryStr, Usuario.class);
		query.setParameter("nome", nome);
		List<Usuario> usuarios = query.getResultList();
		return usuarios.isEmpty() ? null : usuarios.get(0);
	}
	
	public Usuario findByNomsenha(String nome, String senha) {
		String queryStr = "select u from Usuario u where u.nome = :nome and u.senha = :senha";
		TypedQuery<Usuario> query = this.emM.createQuery(queryStr, Usuario.class);
		query.setParameter("nome", nome);
		query.setParameter("senha", senha);
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



	public Usuario getUsuario(String nome, String senha) {
		// TODO Auto-generated method stub
		return null;
	}

}




