package br.com.sindiatacadista.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

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

	@Transactional
	public void atualiza(Empresa empresa) {
		em.merge(empresa);
		
	}
	
	@Transactional
	public void remover(Empresa empresa) {
		em.remove(em.merge(empresa));
	}
	
	public List<Empresa> listaTodasEmpresas() {
		return em.createQuery("select e from Empresa e", Empresa.class).getResultList();
	}



}
