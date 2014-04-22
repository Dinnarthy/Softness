package br.com.softness.cliente;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;








import org.primefaces.event.SelectEvent;

import br.com.softness.endereco.Endereco;

@ManagedBean(name="clienteBean")
@ViewScoped

public class ClienteBean  {
	
	
	private List<Cliente> clientes;
	private Cliente cliente;  
	private Endereco endereco; 
	//private Cliente selectCliente;
	private boolean campos ;
	
	
	public ClienteBean() {
		
	}
	@PostConstruct
	public void init(){
		ClienteRN clienteRN = new ClienteRN();
		clientes = clienteRN.consultaTodosCliente();
		desabilitarCampos();
		
	}

	public void salvar(ActionEvent event){
		 

		
		
				cliente.setEndereco(endereco);
				ClienteRN clienteRN = new ClienteRN();
				clienteRN.salvar(cliente);
				FacesContext context = FacesContext.getCurrentInstance();
		        context.addMessage(null, new FacesMessage( "Cliente cadastrado com sucesso. "));
		        desabilitarCampos();
			
			
			
			
	        System.out.print("Passou pelo Cliente bean");
		}
		
	public void setSelected(Cliente selected) {
        this.cliente = selected;
	}
	 public Cliente getSelected() {
	        return cliente;
	    }
        
	
	
	public void novo(ActionEvent event){
		
		cliente = new Cliente();
		endereco = new Endereco();
		habilitarCampos();
	}
	
	public void cancelar(ActionEvent event){
		habilitarCampos();
	}
	
	public void excluir(ActionEvent event){
		ClienteRN clienteRN = new ClienteRN();

		System.out.print("CLIENTE : "+ cliente.getNome());
		clienteRN.exluir(cliente);
		System.out.print("CLIENTE : "+ cliente.getNome());

		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage( "Cliente excluido com sucesso "));
        cliente=null;
        desabilitarCampos();
		
	}
	
	public String cancelar(){
		
		return "cliente.xhtml";
		
		
	}
	
	public void habilitarCampos(){
		campos = false ;
		
	}
	
	public void desabilitarCampos(){
		campos = true ;
	}
	
	public void onRowSelect(SelectEvent event) {
		
        this.cliente = (Cliente) event.getObject();  
       this.endereco  = cliente.getEndereco();
       System.out.print("ID"+ cliente.getIdCliente());
       
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

	
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	public boolean isCampos() {
		return campos;
	}
	public void setCampos(boolean campos) {
		this.campos = campos;
	}
	
	
	
	
	}
	
	
	
	

	
	
	
	
	

