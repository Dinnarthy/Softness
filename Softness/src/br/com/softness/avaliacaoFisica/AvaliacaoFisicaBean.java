package br.com.softness.avaliacaoFisica;



import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;

import br.com.softness.cliente.Cliente;



@ManagedBean(name = "avaliacaoFisicaBean")
@ViewScoped
public class AvaliacaoFisicaBean {

	private boolean campos ;
	private Double resultadoImc;
	private Double taxaGordura;
	private List<AvaliacaoFisica> listaAvaliacaoFisica = new ArrayList<AvaliacaoFisica>() ;
	private Cliente cliente;
	private String nomeCliente;
	private Cliente cliente2 ;
	private AvaliacaoFisica avaliacaoFisica ;
	
	

	public AvaliacaoFisicaBean() {
		
	}
	@PostConstruct
	public void init(){
		
		
		desabilitarCampos();
								}
	public String cancelar(){
		return "avaliacaoFisica.xhtml";
	}
	
	public void adicionar(ActionEvent event){
		listaAvaliacaoFisica.add(avaliacaoFisica);
		
		
		
	}
	
public void onRowSelect(SelectEvent event) {
		habilitarCampos();
        this.cliente = (Cliente) event.getObject(); 
        nomeCliente=cliente.getNome();
        cliente2 = cliente;
        
        System.out.print("ID----"+ cliente.getIdCliente());
       System.out.print("\n ID----"+ cliente.getNome());
       
    }

public void setSelected(Cliente selected) {
	
    this.cliente = selected;
    
    
}
 public Cliente getSelected() {
	 	
        return cliente;
        
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
		avaliacaoFisica.setCliente(cliente2);
		avaliacaoFisicaRN.salvar(avaliacaoFisica);
		desabilitarCampos();
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(
				"Avalicao Fisica Cadastrada com Sucesso"));
		System.out.print(" \nPassou pelo salvar do ManagedBean \n");

	}
	
	public void calcularImc(){
		
		Double alturaDouble = Double.parseDouble(avaliacaoFisica.getAltura());
		alturaDouble = alturaDouble / 100;
		Double pesoDouble = Double.parseDouble(avaliacaoFisica.getPeso());
		resultadoImc = pesoDouble/(alturaDouble*alturaDouble);
		
		String resultadoImc2 = String.valueOf(resultadoImc);
		avaliacaoFisica.setImc(resultadoImc2);
		if(cliente==null){
		System.out.print("\n\n Cliente está null no Calular IMC");
		}
		System.out.print("----------------"+getResultadoImc());
		System.out.print("----------------"+alturaDouble);
		System.out.print("----------------"+pesoDouble);
		
		


	}
	
	public void calcular(ActionEvent event){
		
		calcularTaxaDeGordura();
		calcularImc();
		calcularSituacaoImc();
	}
	
	public void calcularSituacaoImc(){
		if(resultadoImc < 17 ){
			avaliacaoFisica.setSituacaoImc("Muito Abaixo do Peso");
		}else if(resultadoImc>17 && resultadoImc<18.49){
			avaliacaoFisica.setSituacaoImc("Abaixo do Peso");
		}else if(resultadoImc >18.5 && resultadoImc < 24.99){
			avaliacaoFisica.setSituacaoImc("Peso Normal");
		}else if(resultadoImc>25.00 && resultadoImc<29.99){
			avaliacaoFisica.setSituacaoImc("Acima do Peso");
		}else if(resultadoImc>30.00 && resultadoImc<34.99){
			avaliacaoFisica.setSituacaoImc("Obesidade I ");
		}
		else if(resultadoImc>35.00 && resultadoImc<39.99){
			avaliacaoFisica.setSituacaoImc("Obesidade II (Severa) ");
		}
		else {
			avaliacaoFisica.setSituacaoImc("Obesidade III (Mórbida)");
		}
		
	}
	
	public void calcularTaxaDeGordura(){
		Double alturaDouble = Double.parseDouble(avaliacaoFisica.getAltura());
		Double cinturaDouble = Double.parseDouble(avaliacaoFisica.getCintura());
		Double pescocoDouble = Double.parseDouble(avaliacaoFisica.getPescoco());
		taxaGordura = 495/(1.0324-.19077*(Math.log10(cinturaDouble-pescocoDouble))+.15456*(Math.log10(alturaDouble)))-450;
		taxaGordura = 86.010*Math.log10(cinturaDouble-pescocoDouble)-70.041*Math.log10(alturaDouble)+30.30;
		String gorduraString = String.valueOf(taxaGordura);
		avaliacaoFisica.setTaxaGordura(gorduraString);


		
		
		
	}
	
	

	public void habilitarCampos() {
		campos = false;

	}

	public void desabilitarCampos() {
		campos = true;
	}

	public void novo(ActionEvent event) {
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

	public Double getTaxaGordura() {
		return taxaGordura;
	}

	public void setTaxaGordura(Double taxaGordura) {
		this.taxaGordura = taxaGordura;
	}
	public List<AvaliacaoFisica> getListaAvaliacaoFisica() {
		return listaAvaliacaoFisica;
	}
	public void setListaAvaliacaoFisica(List<AvaliacaoFisica> listaAvaliacaoFisica) {
		this.listaAvaliacaoFisica = listaAvaliacaoFisica;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public Cliente getCliente2() {
		return cliente2;
	}
	public void setCliente2(Cliente cliente2) {
		this.cliente2 = cliente2;
	}
	
	
	
	
	



	
	
	

}
