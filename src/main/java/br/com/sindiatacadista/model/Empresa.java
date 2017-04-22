package br.com.sindiatacadista.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Empresa {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false, length=150)
	private String razaoSocial;
	
	@Column(nullable=false, length=18)
	private String cnpj;
	
	@Column(nullable=false)
	private String telefone;
	
	@Column(nullable=false, length=4)
	private String sitAssociacao;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSitAssociacao() {
		return sitAssociacao;
	}

	public void setSitAssociacao(String sitAssociacao) {
		this.sitAssociacao = sitAssociacao;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + " " + razaoSocial + " " + cnpj + " " + telefone + " " + sitAssociacao;
	}
}
