package br.com.softness.cliente;

import java.util.List;


public interface ClienteDAO {
	
	public List consultaTodosClientes();
	
	public void salvar(Cliente cliente);
	
	public void delete(Cliente cliente);
	
	public void alter(Cliente cliente);
	
	public Cliente getById(Integer idCliente);
	
	public Cliente getByCpf(String email);
	
	public Cliente getByNome(String nome);
	
	public List<Cliente>listar();

}
