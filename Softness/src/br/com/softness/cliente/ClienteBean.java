package br.com.softness.cliente;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean(name="clienteBean")
@ViewScoped
public class ClienteBean {
	
	private String x="Teste";

	public ClienteBean() {
		
	}
	
	public void salvar(ActionEvent actionEvent){
		FacesContext context = FacesContext.getCurrentInstance();  
        
        context.addMessage(null, new FacesMessage("Cadastro Cliente", "Cliente cadastrado com sucesso. "));
        System.out.print("Passou pelo Cliente bean");
        
        
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}
	
	

}
