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
		this.em.remove(funcionario);
	}
	
	public List<Funcionario> listaTodosFuncionariosDaEmpresa(){
		return this.em.createQuery("select f from Funcionario f join f.empresa", Funcionario.class).getResultList();
	}
}
