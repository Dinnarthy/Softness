package br.com.softness.avaliacaoFisica;



import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean(name="avaliacaoFisicaBean")
@ViewScoped
public class AvaliacaoFisicaBean {
	
		 

	private AvaliacaoFisica avaliacaoFisica;
	
	
	
	
	public AvaliacaoFisicaBean() {

		
	}




	public void salvar(ActionEvent event){
		
		System.out.print("Entrou no Salvar");
		AvaliacaoFisicaRN avaliacaoFisicaRN = new AvaliacaoFisicaRN();
		avaliacaoFisicaRN.salvar(avaliacaoFisica);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Avalicao Fisica Cadastrada com Sucesso"));
		
	}
	
	public void novo(ActionEvent event){
		avaliacaoFisica = new AvaliacaoFisica();
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Entrou no Novo"));
	}




	public AvaliacaoFisica getAvaliacaoFisica() {
		return avaliacaoFisica;
	}




	public void setAvaliacaoFisica(AvaliacaoFisica avaliacaoFisica) {
		this.avaliacaoFisica = avaliacaoFisica;
	}
		
	
	
			
			
			
			
		
		
	
	
	

}
