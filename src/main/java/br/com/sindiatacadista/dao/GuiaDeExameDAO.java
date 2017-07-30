package br.com.sindiatacadista.dao;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.sindiatacadista.model.GuiaDeExame;

@SuppressWarnings("serial")
@Stateless
public class GuiaDeExameDAO implements Serializable {

	@PersistenceContext
	private EntityManager em;
	
	public void gravar(GuiaDeExame guiaDeExame){
		this.em.persist(guiaDeExame);
	}
}
