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
