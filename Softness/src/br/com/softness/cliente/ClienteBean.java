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
	private Cliente selectCliente;
	private String x="Testando";
	
	
	
	public ClienteBean() {
		
	}
	@PostConstruct
	public void init(){
		ClienteRN clienteRN = new ClienteRN();
		clientes = clienteRN.consultaTodosCliente();
		if(clientes==null){
			System.out.print("cliente está null");

		}else{
			System.out.print("Clientes nao está null");

		}
	}

	public void salvar(ActionEvent event){
		 

		
		
				cliente.setEndereco(endereco);
				ClienteRN clienteRN = new ClienteRN();
				clienteRN.salvar(cliente);
				FacesContext context = FacesContext.getCurrentInstance();
		        context.addMessage(null, new FacesMessage( "Cliente cadastrado com sucesso. "));
		        cliente=null;
		        endereco=null;
			
			
			
			
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
	}
	
	public String cancelar(){
		
		return "cliente.xhtml";
		
		
	}
	public void onRowSelect(SelectEvent event) {  
        this.cliente = (Cliente) event.getObject();  
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
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	public Cliente getSelectCliente() {
		return selectCliente;
	}
	
	}
	
	
	
	

	
	
	
	
	

