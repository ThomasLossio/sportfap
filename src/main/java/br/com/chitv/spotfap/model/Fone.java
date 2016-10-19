package br.com.chitv.spotfap.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity	
@Table(name="fone", schema="sportfap")
@SequenceGenerator(name = "FoneSequence", sequenceName = "SQ_ID_FONE", allocationSize = 1)

public class Fone implements Serializable{

	private static final long serialVersionUID = -8131959164551050867L;
	/**
	 * 
	 */

	
	public Fone() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FoneSequence")
	private Long id;

	@Column(name = "NUMERO", nullable = true)
	private int numero;
	
	@ManyToOne
	@JoinColumn(name= "usuario_id")
	private Usuario usuario;
	
}
