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

import br.com.chitv.sportfap.model.Time;
import br.com.chitv.sportfap.controller.TimeController;
import br.com.chitv.sportfap.dao.TimeDao;


@Path("/time")
public class RequisicoesTimes {
	@Inject
	private TimeDao timeDao;
	
    @GET @Path("{id}") @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"} )
    public Time getTimeJSON(@PathParam("id") Long id){
    	
        return this.timeDao.findById(id);
    }
//nome, capitao, fone-capitao
    @GET @Path("/salvarTime/{nome}/{capitao}/{fone_capitao}") @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"} )
    public Response getSalvaTimeJSON(@PathParam("nome") String nome, @PathParam("capitao") String capitao, @PathParam("fone_capitao") String fone_capitao){
    	Time time = new Time();
    	time.setNome(nome);
    	time.setCapitao(capitao);
    	time.setFone_capitao(fone_capitao);
    	this.timeDao.salvar(time);
    	return Response.status(200).entity("Feito").build();
    }

    @GET @Path("/excluirTime/{id}") @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"} )
    public Response getExcluiTimeJSON(@PathParam("id") Long id){    	
           	
    	this.timeDao.excluir(this.timeDao.findById(id));
    	return Response.status(200).entity("Feito").build();
    }

    //Ele pediu pra ver com a anotação @QueryParam
    @GET @Path("/listarTimes") @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"} )
    public List<Time> getListaTimesJSON(){    	
        return this.timeDao.listaTimes();
    	
    }    
    
}
