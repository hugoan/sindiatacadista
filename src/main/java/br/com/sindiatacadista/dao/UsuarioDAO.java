package br.com.sindiatacadista.dao;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.sindiatacadista.model.Funcionario;
import br.com.sindiatacadista.model.Usuario;

@SuppressWarnings("serial")
@Stateless
public class UsuarioDAO implements Serializable {

	@PersistenceContext
	private EntityManager em;

	@Inject
	private FuncionarioDAO funcionarioDAO;
	
	public Usuario existe(String cpf, Usuario usuario) {
		Funcionario funcionario = funcionarioDAO.buscaFuncionarioPorCPF(cpf);

		return usuario = buscaUsuario(usuario, funcionario);
		
		// Verifica se usuario existe
//		if (funcionario != null) {
//			usuario = buscaUsuario(usuario, funcionario);
//
//			System.out.println("Funcionario logado é " + funcionario.getNome());
//			return usuario;
//		}

		

	}

	private Usuario buscaUsuario(Usuario usuario, Funcionario funcionario) {
		return em.createQuery("select u from Usuario u where u.funcionario_id = " + funcionario.getId()
				+ " and u.senha = '" + usuario.getSenha() + "'", Usuario.class).getSingleResult();
	}

	
}
