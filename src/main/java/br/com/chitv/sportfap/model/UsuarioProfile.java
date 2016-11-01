package br.com.chitv.sportfap.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "USUARIO_PROFILE", schema="sportfap")
@SequenceGenerator(name = "UsuarioProfileSequence", sequenceName = "Usuario_PROFILE_ID_SQ", initialValue = 1, allocationSize = 1, schema="sportfap")
public class UsuarioProfile implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3191862381501832025L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UsuarioProfileSequence")
	@Basic(optional = false)
	@Column(name="ID")
	private Long id;

	
	@Column(name = "TYPE")
	private String type;

	@OneToMany(mappedBy = "usuarioProfile")
	private List<Usuario> usuarios;

	public UsuarioProfile() {	}

	public UsuarioProfile(Long id) {
		this.id = id;
	}

	public UsuarioProfile(Long id, String type) {
		this.id = id;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "sportfap.UsuariorProfile[ id=" + id + " ]";
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioProfile other = (UsuarioProfile) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}