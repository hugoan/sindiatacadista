package br.com.sindiatacadista.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.sindiatacadista.dao.EmpresaDAO;
import br.com.sindiatacadista.dao.FuncionarioDAO;
import br.com.sindiatacadista.model.Empresa;
import br.com.sindiatacadista.model.Funcionario;

@Named
@RequestScoped
@SuppressWarnings("serial")
public class FuncionarioBean implements Serializable {


	@Inject
	private Funcionario funcionario;
	
	@Inject
	private FuncionarioDAO funcionarioDAO;
	
	@Inject
	private EmpresaDAO empresaDAO; 

	public void carregarNoFormulario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public void salvar() {
		if (funcionario.getId() == null) {
			this.funcionarioDAO.gravar(funcionario);
		} else {
			this.funcionarioDAO.atualizar(funcionario);
		}
		
		this.funcionario = new Funcionario();
	}
	
	@Transactional
	public void remover(Funcionario funcionario){
		funcionarioDAO.remover(funcionario);
		this.funcionario = new Funcionario();
	}

	// Gets e Sets
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> getFuncionarios() {
		return this.funcionarioDAO.listaTodosFuncionariosDaEmpresa();
	}
	
	public List<Empresa> getEmpresas(){
		return this.empresaDAO.listaTodasEmpresas();
	}
	
}
