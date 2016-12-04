package br.com.chitv.sportfap.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.chitv.sportfap.model.Evento;
import br.com.chitv.sportfap.controller.EventoController;
import br.com.chitv.sportfap.dao.EventoDao;



@Path("/evento")
public class RequisicoesEventos {
	@Inject
	private EventoDao eventoDao;
	
    @GET @Path("{id}") @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"} )
    public Evento getEventoJSON(@PathParam("id") Long id){
    	
        return this.eventoDao.findById(id);
    }

    @GET @Path("/salvarEvento/{nome}") @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"} )
    public Response getSalvaEventoJSON(@PathParam("nome") String nome){
    	Evento evento = new Evento();
    	evento.setNome(nome);
    	this.eventoDao.salvar(evento);
    	return Response.status(200).entity("Feito").build();
    }

    @GET @Path("/excluirJogador/{id}") @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"} )
    public Response getExcluiEventoJSON(@PathParam("id") Long id){    	
           	
    	this.eventoDao.excluir(this.eventoDao.findById(id));
    	return Response.status(200).entity("Feito").build();
    }

    //Ele pediu pra ver com a anotação @QueryParam
    @GET @Path("/listarJogadores") @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"} )
    public List<Evento> getListaEventosJSON(){    	
        return this.eventoDao.listaEventos();
    	
    }    
    
}
