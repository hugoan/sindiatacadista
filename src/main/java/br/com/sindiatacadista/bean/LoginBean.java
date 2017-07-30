package br.com.sindiatacadista.bean;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sindiatacadista.dao.UsuarioDAO;
import br.com.sindiatacadista.model.Usuario;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class LoginBean implements Serializable {

	@Inject
	private Usuario usuario;

	@Inject
	private UsuarioDAO usuarioDAO;
	
	private String cpf;
	
	public String iniciaSessao() {
		usuario = usuarioDAO.existe(this.cpf, this.usuario.getSenha());
		
		if(usuario != null){
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getSessionMap().put("usuarioLogado", this.usuario);
			return "pages/funcionario?faces-redirect=true";
		}
				
		usuario = new Usuario();
		return null;
	}

	// Gets and Sets
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
