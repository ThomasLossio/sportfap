package br.com.chitv.sportfap.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="time", schema="sportfap")
@SequenceGenerator(name = "TimeSequence", sequenceName = "SQ_ID_TIME", allocationSize = 1)
public class Time implements Serializable{
	// essa UID ser� diferente em cada classe

		/**
	 * 
	 */
	private static final long serialVersionUID = 5641283102938730404L;

		public Time() {}

		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TimeSequence")
		private Long id;
		
	    @Column(name = "NOME", length = 30, nullable = false)
	    private String nome;
	    
	    @Column(name = "CAPITAO", length = 60 )
	    private String capitao;

	    @Column(name = "FONE_CAPITAO", length = 10 )
	    private String fone_capitao;
	    
	    @OneToMany( mappedBy = "time")	
	    private List<Jogador> jogadores;
	    
	    @ManyToMany(mappedBy = "times")
	    private List<Evento> eventos;

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

		public String getCapitao() {
			return capitao;
		}

		public void setCapitao(String capitao) {
			this.capitao = capitao;
		}

		public String getFone_capitao() {
			return fone_capitao;
		}

		public void setFone_capitao(String fone_capitao) {
			this.fone_capitao = fone_capitao;
		}

		public List<Jogador> getJogadores() {
			return jogadores;
		}

		public void setJogadores(List<Jogador> jogadores) {
			this.jogadores = jogadores;
		}

		public List<Evento> getEventos() {
			return eventos;
		}

		public void setEventos(List<Evento> eventos) {
			this.eventos = eventos;
		}
	    
}
