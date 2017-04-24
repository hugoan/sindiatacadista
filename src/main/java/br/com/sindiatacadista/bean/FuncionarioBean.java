package br.com.sindiatacadista.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.sindiatacadista.dao.EmpresaDAO;
import br.com.sindiatacadista.dao.FuncionarioDAO;
import br.com.sindiatacadista.model.Empresa;
import br.com.sindiatacadista.model.Funcionario;

@Named
@ViewScoped
@SuppressWarnings("serial")
public class FuncionarioBean implements Serializable {

	private Funcionario funcionario = new Funcionario();
	
	
	@Inject
	private FuncionarioDAO funcionarioDAO;

	@Inject
	private EmpresaDAO empresaDAO;

	@Transactional
	public void salvar(Funcionario funcionario) {
		System.out.println("O método salvar da classe funcionarioBean recebeu o seguinte funcionario: " + funcionario);
		if (funcionario.getId() == null) {
			this.funcionarioDAO.gravar(funcionario);
		} else {
			this.funcionarioDAO.atualizar(funcionario);
		}
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
