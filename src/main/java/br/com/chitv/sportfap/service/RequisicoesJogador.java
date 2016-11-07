package br.com.chitv.sportfap.service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.chitv.sportfap.model.Jogador;
import br.com.chitv.sportfap.controller.JogadorController;
import br.com.chitv.sportfap.dao.JogadorDao;


//Ok, de forma a explicar o que foi feito nesta classe. Esta classe serve para controlar as requisições, se é GET ou POST. 
//Primeiro, a anotação @Path define qual caminho acessar pra chegar no método específico.
//Até ai perfeito, dentro da implementação da classe, existem os métodos GET e POST e como podem ser acessados através do @Path
//O método GET funciona usando o seguinte endereço: http://localhost:8080/sportfap/rest/jogador/2
//Ou seja, o que está como {id} é o parâmetro que pretendo receber, qualquer coisa eu explico melhor pessoalmente kk
//O metodo POST não está funcionando, procurar saber com Pablo ou pesquisar na net kk


@Path("/jogador")
public class RequisicoesJogador {
	@Inject
	private JogadorDao jogadorDao;
	
    @GET @Path("{id}") @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"} )
    public Jogador getJogadorJSON(@PathParam("id") Long id){
    	
        return this.jogadorDao.findById(id);
    }
    
    @POST
    @Path("/salvarJogador/{nome}/{numero}/{semestre}/{curso}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response consomeJogadorJSON(@PathParam("nome") String nome, @PathParam("numero") Long numero, @PathParam("semestre") Long semestre, @PathParam("curso") String curso){
    	Jogador jogador = new Jogador();
    	jogador.setNome(nome);
    	jogador.setNumero(numero);
    	jogador.setSemestre(semestre);
    	jogador.setCurso(curso);
    	this.jogadorDao.salvar(jogador);
		return Response.status(200).entity("Feito").build();
    }
}
