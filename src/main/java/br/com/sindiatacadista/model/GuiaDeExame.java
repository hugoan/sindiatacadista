package br.com.sindiatacadista.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class GuiaDeExame {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne (optional = false)
	private Funcionario funcionario;
	
	@Column (nullable = false, length = 80)
	private String funcao; 
	
	@Column (nullable = false)
	private Long idEmpresa;
	
	@Column(nullable = false, length = 11)
	private String tipoExame;
	
	@Temporal (TemporalType.DATE)
	private Calendar dataPedido = Calendar.getInstance();
	
	@ManyToOne (optional = false)
	private Funcionario emissor;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getTipoExame() {
		return tipoExame;
	}

	public void setTipoExame(String tipoExame) {
		this.tipoExame = tipoExame;
	}

	public Calendar getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Calendar dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Funcionario getEmissor() {
		return emissor;
	}

	public void setEmissor(Funcionario emissor) {
		this.emissor = emissor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GuiaDeExame other = (GuiaDeExame) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
	    return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
	}

}
