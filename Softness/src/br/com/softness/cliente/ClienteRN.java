package br.com.softness.cliente;

import java.util.List;

public class ClienteRN {
	
	private ClienteDAO clienteDAO;

	public ClienteRN() {
		this.clienteDAO = ClienteDAOFactory.criarClienteDAO();
	}
	
	public Cliente getById(Integer idCliente){
		
		return clienteDAO.getById(idCliente);
		
	}
	
	public Cliente getByNome(String nome){
		
		return clienteDAO.getByNome(nome);
	}
	
	public Cliente getByCpf(String cpf){
		return clienteDAO.getByCpf(cpf);
	}
	
	public void salvar (Cliente cliente){
		
		Integer idCliente = cliente.getIdCliente();
		if(idCliente==null){
		clienteDAO.salvar(cliente);
		System.out.print("CLienteRN idCliente = 0 ou = NULL");
		}else{
		clienteDAO.alter(cliente);
		System.out.print("CLienteRN idCliente <> 0 ou <> NULL");
		}
		
	}
	public List consultaTodosCliente(){
		return clienteDAO.consultaTodosClientes();
	}
	
	public void exluir(Cliente cliente){
		clienteDAO.delete(cliente);
	}
	
	public List<Cliente> listar(){
		return clienteDAO.listar();
	}
	
	

}
