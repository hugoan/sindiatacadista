package br.com.sindiatacadista.bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sindiatacadista.dao.FuncionarioDAO;
import br.com.sindiatacadista.model.Funcionario;
import br.com.sindiatacadista.model.Usuario;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class LoginBean implements Serializable {
	
	@Inject
	private Usuario usuario;
	
	@Inject 
	private Funcionario funcionario;
	
	@Inject
	private FuncionarioDAO funcionarioDAO;
	
	private String cpf;
	
	public String iniciaSessao(){
		funcionario = funcionarioDAO.buscaFuncionarioPorCPF(cpf);
		System.out.println("Nome do funcionário logado: " + this.funcionario.getNome());
		
		return "pages/funcionario?faces-redirect=true";
				
	}

	//Gets and Sets
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
