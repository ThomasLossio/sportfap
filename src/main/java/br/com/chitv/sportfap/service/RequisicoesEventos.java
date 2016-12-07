package br.com.chitv.sportfap.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.chitv.sportfap.dao.EventoDao;
import br.com.chitv.sportfap.model.Evento;

//nome, data, tipo, regulamento

@Path("/evento")
public class RequisicoesEventos {
	@Inject
	private EventoDao eventoDao;
	
    @GET @Path("{id}") @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"} )
    public Evento getEventoJSON(@PathParam("id") Long id){
    	
        return this.eventoDao.findById(id);
    }

    //Ele pediu pra ver com a anotação @QueryParam
    @GET @Path("/listarEventos") @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"} )
    public List<Evento> getListaEventosJSON(){    	
        return this.eventoDao.listaEventos();
    	
    }    
    
}
