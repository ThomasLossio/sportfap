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

//Ok, de forma a explicar o que foi feito nesta classe. Esta classe serve para controlar as requisi��es, se � GET ou POST. 
//Primeiro @Path define qual caminho acessar pra chegar no m�todo espec�fico.
//At� ai perfeito, dentro da implementa��o da classe, existem os m�todos GET e POST e como podem ser acessados atrav�s do @Path
//O m�todo GET j� funciona, precisa apenas saber como requisitar a lista de jogadores do banco, o qual ainda n�o consegui.
//O metodo POST vou ver com Pablo o Por qu�

@Path("/jogador")
public class RequisicoesJogador {
    @GET @Path("/jogadorGetJson") @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"} )
    public Jogador getJogadorJSON(){
    	JogadorController jogadorController = new JogadorController();
//        mensagem.setCabecalho("Cabe�alho");
//        mensagem.setCorpo("Corpo da mensagem � esse aqui");
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
