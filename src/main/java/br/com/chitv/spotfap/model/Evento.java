package br.com.chitv.spotfap.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO", schema="sportfap")
@SequenceGenerator(name = "UsuarioSequence", sequenceName = "SQ_ID_USUARIO", allocationSize = 1)
public class Evento implements Serializable{

}
