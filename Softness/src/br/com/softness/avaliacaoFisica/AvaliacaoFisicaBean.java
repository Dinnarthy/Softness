package br.com.softness.avaliacaoFisica;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;



@ManagedBean(name = "avaliacaoFisicaBean")
@ViewScoped
public class AvaliacaoFisicaBean implements Serializable {

	private boolean campos ;
	private Double resultadoImc;
	
	private AvaliacaoFisica avaliacaoFisica ;

	@PostConstruct
	public void init(){
		desabilitarCampos();
		
	}

	public void salvar(ActionEvent event) {
		System.out.print("DAta-------------------- "
				+ avaliacaoFisica.getData());
		System.out.print("Altura-------------------- "
				+ avaliacaoFisica.getAltura());
		System.out.print("Cintura--------------------"
				+ avaliacaoFisica.getCintura());
		System.out
				.print("Peso--------------------" + avaliacaoFisica.getPeso());
		System.out.print("\n Entrou no Salvar do ManagedBean \n");
		AvaliacaoFisicaRN avaliacaoFisicaRN = new AvaliacaoFisicaRN();

		avaliacaoFisicaRN.salvar(avaliacaoFisica);
		desabilitarCampos();
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(
				"Avalicao Fisica Cadastrada com Sucesso"));
		System.out.print(" \nPassou pelo salvar do ManagedBean \n");

	}
	
	public void calcularImc(ActionEvent event){
		Double alturaDouble = Double.parseDouble(avaliacaoFisica.getAltura());
		Double pesoDouble = Double.parseDouble(avaliacaoFisica.getPeso());
		resultadoImc = pesoDouble/(alturaDouble*alturaDouble);
		String resultadoImc2 = String.valueOf(resultadoImc);
		avaliacaoFisica.setImc(resultadoImc2);
		System.out.print("----------------"+getResultadoImc());
		System.out.print("----------------"+alturaDouble);
		System.out.print("----------------"+pesoDouble);


	}

	public void habilitarCampos() {
		campos = false;

	}

	public void desabilitarCampos() {
		campos = true;
	}

	public void novo(ActionEvent event) {
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

	public boolean isCampos() {
		return campos;
	}

	public void setCampos(boolean campos) {
		this.campos = campos;
	}

	public Double getResultadoImc() {
		return resultadoImc;
	}

	public void setResultadoImc(Double resultadoImc) {
		this.resultadoImc = resultadoImc;
	}



	
	
	

}
