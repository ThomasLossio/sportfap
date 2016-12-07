package br.com.chitv.sportfap.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="JOGADOR", schema="sportfap")
@SequenceGenerator(name = "JogadorSequence", sequenceName = "SQ_ID_JOGADOR", allocationSize = 1)
public class Jogador implements Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = -8752522486231333211L;
	
	public Jogador() {}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JogadorSequence")
	private Long id;
	
    @Column(name = "NOME", length = 70, nullable = false)
    private String nome;
    
    @Column(name = "NUMERO", nullable = false)
    private Long numero;
    
    @Column(name = "SEMESTRE", nullable = false)
    private Long semestre;
    
    @Column(name = "CURSO", length = 30, nullable = false)
    private String curso;
    
    @ManyToOne
    @JoinColumn(name= "time_id")
	private Time time;
    
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

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Long getSemestre() {
		return semestre;
	}

	public void setSemestre(Long semestre) {
		this.semestre = semestre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
