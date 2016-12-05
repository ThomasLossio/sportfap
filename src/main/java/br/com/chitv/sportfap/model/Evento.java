package br.com.chitv.sportfap.model;

import java.io.Serializable;
import java.util.Date;
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
    
    @Column(name = "DATA", nullable = false)
    private Date data;	
    
    @Column(name = "TIPO", length = 1, nullable = false)
    private char tipo;
    
    @Column(name = "REGULAMENTO", length = 1500, nullable = false)
    private String regulamento;
    
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public String getRegulamento() {
		return regulamento;
	}

	public void setRegulamento(String regulamento) {
		this.regulamento = regulamento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Time> getTimes() {
		return times;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
	}

	@ManyToOne
	@JoinColumn(name= "usuario_id")
	private Usuario usuario;
		
	@ManyToMany
	@JoinTable(schema = "sportfap" ,name = "evento_time")
	private List<Time> times;
}
