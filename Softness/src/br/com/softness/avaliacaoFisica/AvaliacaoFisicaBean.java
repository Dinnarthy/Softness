package br.com.softness.avaliacaoFisica;



import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;


import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.softness.cliente.Cliente;

@ManagedBean(name="avaliacaoFisicaBean")
@ViewScoped
public class AvaliacaoFisicaBean {
	
		 
	private boolean campos=true; 

	private AvaliacaoFisica avaliacaoFisica;
	private Cliente cliente;
	
	
	
	




	public AvaliacaoFisicaBean() {
		
	}

	public void salvar(ActionEvent event){
		System.out.print("DAta-------------------- "+avaliacaoFisica.getData());
		System.out.print("Altura-------------------- "+avaliacaoFisica.getAltura());
		System.out.print("Cintura--------------------"+avaliacaoFisica.getCintura());
		System.out.print("Peso--------------------"+avaliacaoFisica.getPeso());
		System.out.print("Entrou no Salvar");
		AvaliacaoFisicaRN avaliacaoFisicaRN = new AvaliacaoFisicaRN();
		avaliacaoFisicaRN.salvar(avaliacaoFisica);
		desabilitarCampos();
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Avalicao Fisica Cadastrada com Sucesso"));
		System.out.print("Passou pelo clienteBean");

	}
	
	public void habilitarCampos(){
		campos = false ;
		
	}
	
	public void desabilitarCampos(){
		campos = true ;
	}
	
	



	public void novo(ActionEvent event){
		avaliacaoFisica = new AvaliacaoFisica();
		
		habilitarCampos();
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Entrou no Novo"));
	}




	public AvaliacaoFisica getAvaliacaoFisica() {
		return avaliacaoFisica;
	}




	public void setAvaliacaoFisica(AvaliacaoFisica avaliacaoFisica) {
		this.avaliacaoFisica = avaliacaoFisica;
	}


	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public boolean isCampos() {
		return campos;
	}

	public void setCampos(boolean campos) {
		this.campos = campos;
	}

		
	
	
			
			
			
			
		
		
	
	
	

}
