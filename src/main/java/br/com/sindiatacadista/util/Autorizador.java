package br.com.sindiatacadista.util;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.sindiatacadista.model.Usuario;

public class Autorizador implements PhaseListener{

	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext context = event.getFacesContext();
		String nomePagina = context.getViewRoot().getViewId();
		System.out.println(nomePagina);
		
		//Permite o acesso a p�gina login
		if("/login.xhtml".equals(nomePagina)){
			return;
		}
		
		//Recupera o usu�rio logado com base na chave 'usuarioLogado'
		Object usuarioLogado = (Usuario) context.getExternalContext().getSessionMap().get("usuarioLogado");
		
		//Verifica se existe usu�rio logado
		if(usuarioLogado != null){
			return;
		}
		
		//Se n�o houver usu�rio logado � redirecionado para p�gina login
		NavigationHandler handler = context.getApplication().getNavigationHandler();
		handler.handleNavigation(context, null, "/login?faces-redirect=true");
		context.renderResponse();
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
