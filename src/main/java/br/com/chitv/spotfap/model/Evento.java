package br.com.chitv.spotfap.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="evento", schema="sportfap")
@SequenceGenerator(name = "EventoSequence", sequenceName = "SQ_ID_EVENTO", allocationSize = 1)
public class Evento implements Serializable{
	
	
	private static final long serialVersionUID = -5385611801003409112L;

	public Evento() {}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EventoSequence")
	private Long id;
	
    @Column(name = "LOGIN", length = 30, nullable = false)
    private String login;
    
    @Column(name = "SENHA", nullable = false)
    private String senha;

    @Column(name = "EMAIL", length = 50, nullable = false, unique = true)
    private String email;
    
}
