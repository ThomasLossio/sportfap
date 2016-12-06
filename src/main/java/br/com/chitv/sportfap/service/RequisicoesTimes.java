package br.com.chitv.sportfap.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.chitv.sportfap.dao.TimeDao;
import br.com.chitv.sportfap.model.Evento;
import br.com.chitv.sportfap.model.Time;


@Path("/time")
public class RequisicoesTimes {
	@Inject
	private TimeDao timeDao;
	
    @GET @Path("{id}") @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"} )
    public Time getTimeJSON(@PathParam("id") Long id){
    	
        return this.timeDao.findById(id);
    }
//nome, capitao, fone-capitao
    @GET @Path("/salvarTime/{nome}/{capitao}/{fone_capitao}/{id_Evento}") @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"} )
    public Response getSalvaTimeJSON(@PathParam("nome") String nome, @PathParam("capitao") String capitao, @PathParam("fone_capitao") String fone_capitao, @PathParam("id_Evento") Long id_Evento){
    	Time time = new Time();
    	time.setNome(nome);
    	time.setCapitao(capitao);
    	time.setFone_capitao(fone_capitao);
    	HttpURLConnection connection = null;
    	try{
	    	URL url = new URL("http://localhost:8080/sportfap/rest/evento/" + id_Evento);
	    	connection = (HttpURLConnection)url.openConnection();
	    	InputStream content = connection.getInputStream();
	    	Evento evento = new Evento();
	    	
	    	
    	} catch (IOException ex){
    		throw new RuntimeException();
    	} finally {
			connection.disconnect();
		}

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

    @GET @Path("/listarTimesEvento") @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"} )
    public List<Time> getListaTimesEventoJSON(){    	
        return this.timeDao.listaTimes();
    	
    }    
    
}
