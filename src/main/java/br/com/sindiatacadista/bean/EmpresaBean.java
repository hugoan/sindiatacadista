package br.com.sindiatacadista.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.sindiatacadista.dao.EmpresaDAO;
import br.com.sindiatacadista.model.Empresa;

@Named
@ViewScoped
@SuppressWarnings("serial")
public class EmpresaBean implements Serializable {

	private Empresa empresa = new Empresa();

	@Inject
	private EmpresaDAO dao;
	
	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public void carregarNoFormulario(Empresa empresa) {
		System.out.println("O id da empresa na hora de carregar no formulário é:" + empresa.getId());
		this.empresa = empresa;
	}

	@Transactional
	public void cadastrar() {
		System.out.println("O id da empresa é: " + empresa.getId());
	
		if (this.empresa.getId() == null)
			this.dao.gravar(this.empresa);
		else {
			this.dao.atualiza(this.empresa);
		}

		this.empresa = new Empresa();

	}

	public List<Empresa> getEmpresas() {
		return dao.listaTodasEmpresas();
	}

	@Transactional
	public void remover(Empresa empresa) {
		dao.remover(empresa);
		empresa = new Empresa();
	}

}
