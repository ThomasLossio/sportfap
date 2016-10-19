package br.com.chitv.spotfap.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="jogador", schema="sportfap")
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
    
    
    
    
	

}
