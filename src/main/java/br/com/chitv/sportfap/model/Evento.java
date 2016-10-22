package br.com.chitv.sportfap.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="evento", schema="sportfap")
@SequenceGenerator(name = "EventoSequence", sequenceName = "SQ_ID_EVENTO", allocationSize = 1)
public class Evento implements Serializable{
	
	// essa UID ser� diferente em cada classe
	private static final long serialVersionUID = -5385611801003409112L;

	public Evento() {}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EventoSequence")
	private Long id;
	
    @Column(name = "NOME", length = 50, nullable = false)
    private String nome;
    
	@ManyToOne
	@JoinColumn(name= "usuario_id")
	private Usuario usuario;
		
	@ManyToMany
	@JoinTable(schema = "sportfap" ,name = "evento_time")
	private List<Time> times;
}
