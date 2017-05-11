package br.com.sindiatacadista.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sindiatacadista.dao.EmpresaDAO;
import br.com.sindiatacadista.model.Empresa;

@Named
@ViewScoped
@SuppressWarnings("serial")
public class EmpresaBean implements Serializable {

	@Inject
	private Empresa empresa;

	@Inject
	private EmpresaDAO dao;

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public void carregarNoFormulario(Empresa empresa) {
		this.empresa = empresa;
	}

	public void salvar() {
		if (this.empresa.getId() == null)
			this.dao.gravar(this.empresa);
		else {
			this.dao.atualizar(this.empresa);
		}

		this.empresa = new Empresa();

	}

	public List<Empresa> getEmpresas() {
		return dao.listaTodasEmpresas();
	}

	public void remover(Empresa empresa) {
		dao.remover(empresa);
		empresa = new Empresa();
	}

}
