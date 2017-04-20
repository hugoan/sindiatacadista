package br.com.sindiatacadista.bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.sindiatacadista.model.Funcionario;

@Named
@ViewScoped
@SuppressWarnings("serial")
public class FuncionarioBean implements Serializable {

	private Funcionario funcionario = new Funcionario();
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
