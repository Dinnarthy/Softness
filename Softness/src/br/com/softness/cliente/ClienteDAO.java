package br.com.softness.cliente;

import java.util.List;


public interface ClienteDAO {
	
	public void salvar(Cliente user);
	
	public void delete(Cliente user);
	
	public void alter(Cliente user);
	
	public Cliente getById(Integer idCliente);
	
	public Cliente getByEmail(String email);
	
	public Cliente getByNome(String nome);
	
	public List<Cliente>listar();

}
