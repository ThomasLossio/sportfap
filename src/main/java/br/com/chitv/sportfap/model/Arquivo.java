package br.com.chitv.sportfap.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ARQUIVO")
@SequenceGenerator(name="ArquivoSequence", sequenceName="ARQUIVO_ID_SQ", allocationSize=1, initialValue=1)
public class Arquivo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7973543945077214216L;
	
	public Arquivo() {	}
	
	public Arquivo(byte[] arquivo) {
		this.arquivo = arquivo;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ArquivoSequence")
	private Long id;

	@Lob
	private byte[] arquivo;

	public byte[] getArquivo() {
		return arquivo;
	}

	public void setArquivo(byte[] arquivo) {
		this.arquivo = arquivo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		Arquivo other = (Arquivo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
