package br.com.chitv.sportfap.service;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.chitv.sportfap.dao.UsuarioDao;
import br.com.chitv.sportfap.model.Usuario;
 

@ViewScoped
public class LoginManagedBean {
 
      private UsuarioDao usuarioDao = new UsuarioDao();
      private Usuario usuario = new Usuario();
      
      public String envia() {
            
            usuario = usuarioDao.getUsuario(usuario.getNome(), usuario.getSenha());
            if (usuario == null) {
                  usuario = new Usuario();
                  FacesContext.getCurrentInstance().addMessage(
                             null,
                             new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!",
                                         "Erro no Login!"));
                  return null;
            } else {
                  return "/main";
            }
            
            
      }
 
      public Usuario getUsuario() {
            return usuario;
      }
 
      public void setUsuario(Usuario usuario) {
            this.usuario = usuario;
      }
}