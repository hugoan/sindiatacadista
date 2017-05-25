package br.com.sindiatacadista.dao;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.sindiatacadista.model.Funcionario;

@SuppressWarnings("serial")
@Stateless
public class UsuarioDAO implements Serializable {

	@PersistenceContext
	private EntityManager em;

	public Funcionario buscarFuncionarioPorCPF(String cpf) {
		Funcionario funcionario = em.find(Funcionario.class, cpf);
		return funcionario;
	}

}
