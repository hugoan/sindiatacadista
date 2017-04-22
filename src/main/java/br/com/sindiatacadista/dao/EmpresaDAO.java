package br.com.sindiatacadista.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.sindiatacadista.model.Empresa;

@SuppressWarnings("serial")
@Stateless
public class EmpresaDAO implements Serializable {

	@PersistenceContext
	private EntityManager em;

	public void gravar(Empresa empresa) {
		System.out.println("Objeto na entrada do DAO" + empresa);
		this.em.persist(empresa);
	}

	//@Transactional
	public void atualizar(Empresa empresa) {
		this.em.merge(empresa);

	}

	//@Transactional
	public void remover(Empresa empresa) {
		this.em.remove(em.merge(empresa));
	}

	public List<Empresa> listaTodasEmpresas() {
		return this.em.createQuery("select e from Empresa e", Empresa.class).getResultList();
	}

	public Empresa buscarPorId(Long id) {
		return this.em.find(Empresa.class, id);
	}

}
