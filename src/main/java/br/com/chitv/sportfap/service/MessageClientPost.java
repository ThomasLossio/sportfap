package br.com.chitv.sportfap.service;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import br.com.chitv.sportfap.model.Mensagem;


public class MessageClientPost {

    public static void main(String args[]){
    	try {
	    	ResteasyClient client = new ResteasyClientBuilder().build();
	    	
	    	ResteasyWebTarget target = client.target("http://localhost:8081/sportfap/mensagem/mensagemPostJson");
	    	
	    	Mensagem msg = new Mensagem();
	    	msg.setCabecalho("Mensagem top");
	    	msg.setCorpo("Corpo sucesso");
	    	
            // Exemplo de requisição post:
	    	Response response = target.request().post(Entity.entity(msg, MediaType.APPLICATION_JSON));
	
	    	if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
			}
	        
	        System.out.println("====> Status da resposta: " + response.getStatus() + "\n");

	        String resposta = response.readEntity(String.class);
	        System.out.println("====> Resposta do servidor:");
	        System.out.println( resposta + "\n");
	
	        response.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
    }

}