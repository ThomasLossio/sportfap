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
	private static final long serialVersionUID = 3770202033825738465L;



	/**
	 * 
	 */
	
	
	public Usuario() {}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UsuarioSequence")
	private Long id;
	
	

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Fone> getFones() {
		return fones;
	}

	public void setFones(List<Fone> fones) {
		this.fones = fones;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

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
