package br.com.chitv.sportfap.service;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

//Essa classe n�o precisa alterar, pois o Wildfly vai reconhecer devido ao /rest na anota��o @ApplicationPath. N�O ALTERAR NADA AQUI, POR FAVOR kkk
@ApplicationPath("/rest")
public class AtivadorRest extends Application {

}
