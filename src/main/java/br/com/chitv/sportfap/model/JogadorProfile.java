package br.com.chitv.sportfap.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "JOGADOR_PROFILE", schema="sportfap")
@SequenceGenerator(name = "JogadorProfileSequence", sequenceName = "Jogador_PROFILE_ID_SQ", initialValue = 1, allocationSize = 1, schema="sportfap")
public class JogadorProfile implements Serializable {

	private static final long serialVersionUID = -6327591337127181910L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JogadorProfileSequence")
	@Basic(optional = false)
	@Column(name="ID")
	private Long id;

	@Column(name = "TYPE")
	private String type;

	@ManyToMany(mappedBy = "jogadorProfiles")
	
	private List<Jogador> jogadores;

	public JogadorProfile() {	}

	public JogadorProfile(Long id) {
		this.id = id;
	}

	public JogadorProfile(Long id, String type) {
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
		return "sportfap.JogadorProfile[ id=" + id + " ]";
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
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
	JogadorProfile other = (JogadorProfile) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}