package br.com.sindiatacadista.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.sindiatacadista.dao.FuncionarioDAO;
import br.com.sindiatacadista.dao.GuiaDeExameDAO;
import br.com.sindiatacadista.model.Funcionario;
import br.com.sindiatacadista.model.GuiaDeExame;
import br.com.sindiatacadista.model.Usuario;

@Named
@RequestScoped
@SuppressWarnings("serial")
public class GuiaDeExameBean implements Serializable {

	@Inject
	private GuiaDeExame guiaDeExame;

	@Inject
	private GuiaDeExameDAO guiaDeExameDAO;

	@Inject
	private FuncionarioDAO funcionarioDAO;

	// Captura o usuário logado
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
	private Funcionario funcionarioLogado = usuarioLogado.getFuncionario();

	public GuiaDeExame getGuiaDeExame() {
		return guiaDeExame;
	}

	public void setGuiaDeExame(GuiaDeExame guiaDeExame) {
		this.guiaDeExame = guiaDeExame;
	}

	// Gets and Sets
	public List<Funcionario> getFuncionarios() {
		return this.funcionarioDAO.listaTodosFuncionariosDaEmpresa(funcionarioLogado);
	}

}
