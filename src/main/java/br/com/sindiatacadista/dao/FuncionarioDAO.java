package br.com.sindiatacadista.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.sindiatacadista.model.Funcionario;

@SuppressWarnings("serial")
@Stateless
public class FuncionarioDAO implements Serializable {

	@PersistenceContext
	private EntityManager em;
	
	public void gravar(Funcionario funcionario) {
		this.em.persist(funcionario);
	}
	
	
	public void atualizar(Funcionario funcionario){
		this.em.merge(funcionario);
	}
	
	
	public void remover(Funcionario funcionario){
		this.em.remove(em.merge(funcionario));
	}
	
	public List<Funcionario> listaTodosFuncionariosDaEmpresa(Funcionario funcionarioLogado){
		return this.em.createQuery("select f from Funcionario f where empresa = " + funcionarioLogado.getEmpresa().getId()).getResultList();
	}
	
	public Funcionario buscaFuncionarioPorCPF(String cpf){
		try{
		return this.em.createQuery("select f from Funcionario f where cpf = '" + cpf + "'", Funcionario.class).getSingleResult();
		} catch (RuntimeException erro) {
			System.out.println("Funcion�rio n�o cadastrado no sistema");
			return null;
		}
	}
}
