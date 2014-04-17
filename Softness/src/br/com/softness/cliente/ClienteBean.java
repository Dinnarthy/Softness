package br.com.softness.cliente;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.softness.endereco.Endereco;

@ManagedBean(name="clienteBean")
@ViewScoped

public class ClienteBean {
	
	
	
	private Cliente cliente;  
	private Endereco endereco; 
	
	private String x="Testando";
	
	
	
	public ClienteBean() {
		
	}

	public void salvar(ActionEvent event){
		
		FacesContext context = FacesContext.getCurrentInstance();  
		System.out.print("ENTROU NO SALVAR NO MANAGEDBEAN");
		
        
        System.out.println("##############"+cliente.getNome());
	    System.out.println("##############"+cliente.getEmail());
	    System.out.println("##############"+cliente.getCpf());
	    System.out.println("##############"+cliente.getDataNascimento());
	    System.out.println("##############"+endereco.getBairro());
	   
		cliente.setEndereco(endereco);
		
		ClienteRN clienteRN = new ClienteRN();
		clienteRN.salvar(cliente);
		
		
		
		
        
        context.addMessage(null, new FacesMessage( "Cliente cadastrado com sucesso. "));
        System.out.print("Passou pelo Cliente bean");
        
        
	}
	
	public void novo(ActionEvent event){
		cliente = new Cliente();
		endereco = new Endereco();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	
	
	
	
	

}
