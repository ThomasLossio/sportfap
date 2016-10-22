package br.com.chitv.sportfap.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    
    @Column(name = "NOME", length = 80, nullable = false)
    private String nome;
    
    @Column(name = "SENHA", length = 30, nullable = false)
    private String senha;
    
    @Column(name = "EMAIL", length = 30, nullable = true)
    private String email;

    @Column(name = "CPF", length = 15, nullable = true)
    private String cpf;  
    
    @OneToMany(mappedBy = "usuario")
    private List<Fone> fones;
    
    @OneToMany(mappedBy = "usuario")
    private List<Evento> eventos;

}	
