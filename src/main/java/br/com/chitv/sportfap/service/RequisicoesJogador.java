package br.com.chitv.sportfap.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.chitv.sportfap.model.Jogador;
import br.com.chitv.sportfap.controller.JogadorController;;

//Ok, de forma a explicar o que foi feito nesta classe. Esta classe serve para controlar as requisições, se é GET ou POST. 
//Primeiro @Path define qual caminho acessar pra chegar no método específico.
//Até ai perfeito, dentro da implementação da classe, existem os métodos GET e POST e como podem ser acessados através do @Path
//O método GET já funciona, precisa apenas saber como requisitar a lista de jogadores do banco, o qual ainda não consegui.
//O metodo POST vou ver com Pablo o Por quê

@Path("/jogador")
public class RequisicoesJogador {
    @GET @Path("/jogadorGetJson") @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"} )
    public Jogador getJogadorJSON(){
    	JogadorController jogadorController = new JogadorController();
//        mensagem.setCabecalho("Cabeçalho");
//        mensagem.setCorpo("Corpo da mensagem é esse aqui");
    	List<Jogador> jogadores = jogadorController.getJogadores();
    	Jogador jogador = new Jogador();
    	jogador.setId(jogadores.get(0).getId());
    	jogador.setNumero(jogadores.get(0).getNumero());
    	jogador.setSemestre(jogadores.get(0).getSemestre());
    	jogador.setCurso(jogadores.get(0).getCurso());
    	jogador.setNome(jogadores.get(0).getNome());
        return jogador;
    }
    
    @POST
    @Path("/jogadorPostJson")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response consomeJogadorJSON(Jogador jogador){
    	String result = "Product created : " + jogador;
		return Response.status(200).entity(result).build();
    }
}
