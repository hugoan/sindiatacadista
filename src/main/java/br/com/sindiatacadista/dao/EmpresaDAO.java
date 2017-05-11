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
		this.em.persist(empresa);
	}

	public void atualizar(Empresa empresa) {
		this.em.merge(empresa);

	}

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
