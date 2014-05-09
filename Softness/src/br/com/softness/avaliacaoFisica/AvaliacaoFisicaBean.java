package br.com.softness.avaliacaoFisica;




import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;

import br.com.softness.acompanhamentoFisico.AcompanhamentoFisico;
import br.com.softness.acompanhamentoFisico.AcompanhamentoFisicoRN;
import br.com.softness.cliente.Cliente;



@ManagedBean(name = "avaliacaoFisicaBean")
@ViewScoped
public class AvaliacaoFisicaBean {
	
	private String campoPesquisa;
	private String selecaoPesquisa;
	private boolean campos ;
	private boolean botoes ;
	private Double resultadoImc;
	private Double taxaGordura;
	//private List<AvaliacaoFisica> listaAvaliacaoFisica = new ArrayList<AvaliacaoFisica>() ;
	private List<AvaliacaoFisica> listaAvaliacaoFisica = new ArrayList<AvaliacaoFisica>() ;
	private List<AcompanhamentoFisico> listaAcompanhamentoFisico = new ArrayList<AcompanhamentoFisico>();
	
	private Cliente cliente;
	private String nomeCliente;
	private Cliente cliente2 ;
	private AvaliacaoFisica avaliacaoFisica ;
	private AcompanhamentoFisico acompanhamentoFisico;
	private int contAdicionar=0;  //variavel para desabilitar botao adicionar quando adicionado companhamento
	
	

	public AvaliacaoFisicaBean() {
		
	}
	@PostConstruct
	public void init(){
		AvaliacaoFisicaRN avaliacaoFisicaRN = new AvaliacaoFisicaRN();
		listaAvaliacaoFisica = avaliacaoFisicaRN.listarTodos();
		
		
		
		desabilitarBotoes();
		desabilitarCampos();
								}
	

	
	public String cancelar(){
		return "avaliacaoFisica.xhtml";
	}
	
	public void pesquisarAvaliacaoFisica(ActionEvent event){
		AvaliacaoFisicaRN avaliacaoFisicaRN = new AvaliacaoFisicaRN();
		if(selecaoPesquisa.equals("cpf")){
			listaAvaliacaoFisica = avaliacaoFisicaRN.listarAvaliacaoFisicaByCpf(campoPesquisa);
		}else{
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					"Consulta ainda n�o programada"));
			
		}
		
	}
	
	
	public void adicionar(ActionEvent event){
		Date data = new Date();
		AcompanhamentoFisicoRN acompanhamentoFisicoRN = new AcompanhamentoFisicoRN();
		List<AcompanhamentoFisico> acompanhamento1 = acompanhamentoFisicoRN.listarAcompanhamentoFisicoByData(data);
		if(acompanhamento1==null){
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					"Nao existe acompanhamento desse paciente feita hoje"));
		}else{
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					"J� existe acompanhamento desse paciente feita hoje"));
		}
		if(contAdicionar==0){
			listaAcompanhamentoFisico.add(acompanhamentoFisico);
		}else{
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					"Consulta ainda n�o programada"));
		}
	
	
			
	
		
				
				}
			
				
			
			
			
			
			
			
	
	     
			
		
		
		
		
	
	/*----------INICIO--Tabela de Consultar Paciente em AvaliacaoFisica.xhtml--------   */
public void onRowSelect(SelectEvent event) {
		habilitarCampos();
        this.cliente = (Cliente) event.getObject(); 
        nomeCliente=cliente.getNome();
        //cliente2 = cliente;
        
        System.out.print("ID------------------------"+ cliente.getIdCliente());
       System.out.print("\n ID-------------------------"+ cliente.getNome());
       
    }

/*public void setSelected(Cliente selected) {
	
    this.cliente = selected;
    
    
}

 public Cliente getSelected() {
	 	
        return cliente;
        
    }*/
 /*------------FIM--- Tabela de Consultar Paciente em AvaliacaoFisica.xhtml--------   

 public void setSelected2(AvaliacaoFisica selected){
	 this.avaliacaoFisica = selected ;
 }
 public AvaliacaoFisica getSelected2(){
	 return avaliacaoFisica;
 }*/
 public void onRowSelect2(SelectEvent event){
	 this.avaliacaoFisica = (AvaliacaoFisica) event.getObject();
	 nomeCliente = avaliacaoFisica.getCliente().getNome();
	 cliente = avaliacaoFisica.getCliente();
	 AcompanhamentoFisicoRN acompanhamentoFisicoRN = new AcompanhamentoFisicoRN();
	 listaAcompanhamentoFisico = acompanhamentoFisicoRN.listarAcompnhamentoFisicoByIdAvaliacao(avaliacaoFisica.getIdAvaliacaoFisica());
	 avaliacaoFisica.setAcompanhamentos(listaAcompanhamentoFisico);
	 if(listaAcompanhamentoFisico==null){
		 System.out.print("ListaAcompanhamentoFisico est� null");
	 }else{
		 System.out.print("ListaAcompanhamentoFisico est� populada");

	 }
	 
	 
 }

	public void salvar(ActionEvent event) {
		
		System.out.print("\n Entrou no Salvar do ManagedBean \n");
		AvaliacaoFisicaRN avaliacaoFisicaRN = new AvaliacaoFisicaRN();
		avaliacaoFisica.setCliente(cliente);
		if(avaliacaoFisica==null){
			System.out.print("\n ---------------------------A AvaliacaoFisica est� null-------------------- \n");

		}else{
			System.out.print("\n ---------------------------A AvaliacaoFisica n�o est� null-------------------- \n");
		}
		
		acompanhamentoFisico.setAvaliacaoFisica(avaliacaoFisica);
		AcompanhamentoFisicoRN acompanhamentoFisicoRN = new AcompanhamentoFisicoRN();
		acompanhamentoFisicoRN.salvar(acompanhamentoFisico);
		avaliacaoFisicaRN.salvar(avaliacaoFisica);
		desabilitarBotoes();
		desabilitarCampos();
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(
				"Avalicao Fisica Cadastrada com Sucesso"));
		System.out.print(" \nPassou pelo salvar do ManagedBean \n");

	}
	
	public void editar(ActionEvent event){
		acompanhamentoFisico = new AcompanhamentoFisico();
		habilitarCampos();
	}
	
	public void calcularImc(){
		
		Double alturaDouble = Double.parseDouble(acompanhamentoFisico.getAltura());
		alturaDouble = alturaDouble / 100;
		Double pesoDouble = Double.parseDouble(acompanhamentoFisico.getPeso());
		resultadoImc = pesoDouble/(alturaDouble*alturaDouble);
		
		String resultadoImc2 = String.valueOf(resultadoImc);
		acompanhamentoFisico.setImc(resultadoImc2);
		if(cliente==null){
		System.out.print("\n\n Cliente est� null no Calular IMC");
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
			acompanhamentoFisico.setSituacaoImc("Muito Abaixo do Peso");
		}else if(resultadoImc>17 && resultadoImc<18.49){
			acompanhamentoFisico.setSituacaoImc("Abaixo do Peso");
		}else if(resultadoImc >18.5 && resultadoImc < 24.99){
			acompanhamentoFisico.setSituacaoImc("Peso Normal");
		}else if(resultadoImc>25.00 && resultadoImc<29.99){
			acompanhamentoFisico.setSituacaoImc("Acima do Peso");
		}else if(resultadoImc>30.00 && resultadoImc<34.99){
			acompanhamentoFisico.setSituacaoImc("Obesidade I ");
		}
		else if(resultadoImc>35.00 && resultadoImc<39.99){
			acompanhamentoFisico.setSituacaoImc("Obesidade II (Severa) ");
		}
		else {
			acompanhamentoFisico.setSituacaoImc("Obesidade III (M�rbida)");
		}
		
	}
	
	public void calcularTaxaDeGordura(){
		Double alturaDouble = Double.parseDouble(acompanhamentoFisico.getAltura());
		Double cinturaDouble = Double.parseDouble(acompanhamentoFisico.getCintura());
		Double pescocoDouble = Double.parseDouble(acompanhamentoFisico.getPescoco());
		taxaGordura = 495/(1.0324-.19077*(Math.log10(cinturaDouble-pescocoDouble))+.15456*(Math.log10(alturaDouble)))-450;
		taxaGordura = 86.010*Math.log10(cinturaDouble-pescocoDouble)-70.041*Math.log10(alturaDouble)+30.30;
		String gorduraString = String.valueOf(taxaGordura);
		acompanhamentoFisico.setTaxaGordura(gorduraString);


		
		
		
	}
	public void habilitarBotoes(){
	botoes = false ;
	}
	
	public void desabilitarBotoes(){
	botoes = true;	
	}
	

	public void habilitarCampos() {
		campos = false;

	}

	public void desabilitarCampos() {
		campos = true;
	}

	public void novo(ActionEvent event) {
		avaliacaoFisica = new AvaliacaoFisica();
		acompanhamentoFisico = new AcompanhamentoFisico();
		habilitarBotoes();
		
		
		
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
	public String getSelecaoPesquisa() {
		return selecaoPesquisa;
	}
	public void setSelecaoPesquisa(String selecaoPesquisa) {
		this.selecaoPesquisa = selecaoPesquisa;
	}
	public String getCampoPesquisa() {
		return campoPesquisa;
	}
	public void setCampoPesquisa(String campoPesquisa) {
		this.campoPesquisa = campoPesquisa;
	}
	public AcompanhamentoFisico getAcompanhamentoFisico() {
		return acompanhamentoFisico;
	}
	public void setAcompanhamentoFisico(AcompanhamentoFisico acompanhamentoFisico) {
		this.acompanhamentoFisico = acompanhamentoFisico;
	}
	public List<AcompanhamentoFisico> getListaAcompanhamentoFisico() {
		return listaAcompanhamentoFisico;
	}
	public void setListaAcompanhamentoFisico(
			List<AcompanhamentoFisico> listaAcompanhamentoFisico) {
		this.listaAcompanhamentoFisico = listaAcompanhamentoFisico;
	}
	public int getContAdicionar() {
		return contAdicionar;
	}
	public void setContAdicionar(int contAdicionar) {
		this.contAdicionar = contAdicionar;
	}
	public boolean isBotoes() {
		return botoes;
	}
	public void setBotoes(boolean botoes) {
		this.botoes = botoes;
	}
	
	
	
	
	
	
	



	
	
	

}
