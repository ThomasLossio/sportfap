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
@Table(name="USUARIO", schema="sportfap")
@SequenceGenerator(name = "UsuarioSequence", sequenceName = "SQ_ID_USUARIO", allocationSize = 1)
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8013754050546530823L;
	
	public Usuario() {}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UsuarioSequence")
	private Long id;
	

    @Column(name = "LOGIN", length = 30, nullable = false)
    private String login;
	

}
