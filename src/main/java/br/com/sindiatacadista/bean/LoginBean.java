package br.com.sindiatacadista.bean;

import java.io.Serializable;

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
		usuario = usuarioDAO.existe(this.cpf, this.usuario);

		System.out.println("Usuário logado é " + usuario.getFuncionario().getNome());
		
		return "pages/funcionario?faces-redirect=true";
//		
//		if (usuario != null) {
//			return "pages/funcionario?faces-redirect=true";
//		}
//
//		return "login?faces-redirect=true";
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
