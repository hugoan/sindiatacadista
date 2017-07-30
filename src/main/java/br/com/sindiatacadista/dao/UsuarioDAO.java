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

	@Inject
	private Usuario usuario;

	public Usuario existe(String cpf, String senha) {

		// Verifica se existe algum funcionário com o CPF informado
		Funcionario funcionario = funcionarioDAO.buscaFuncionarioPorCPF(cpf);
		if (funcionario == null) {
			return null;

			// Verifica se funcionário existe como usuário
		} else {
			usuario = buscaUsuario(funcionario, senha);
			if (usuario == null) {
				return null;

				// Verifica se cadastro da empresa está ativo
			} else if (funcionario.getEmpresa().getSitAssociacao().equals("Não")) {
				System.out.println(
						"Ops... Não deixe de usufruir dos beneficios. Entre em contato com Sindiatacadista para ativar o cadastro da empresa");
				return null;

				// Verifica se o cadastro do usuário está ativo
			} else if (funcionario.getAtivo().equals("Não")) {
				System.out.println("Seu cadastro não está ativo. Entre em contato com o administrator da empresa");
				return null;
			}
			
			return usuario;
		}
	}

	private Usuario buscaUsuario(Funcionario funcionario, String senha) {
		try {
			return em.createQuery(
					"select u from Usuario u where u.funcionario =" + funcionario.getId() + "and u.senha = " + senha,
					Usuario.class).getSingleResult();
		} catch (RuntimeException erro) {
			System.out.println("Login ou senha incorredo");
			return null;
		}
	}
}
