package br.com.softness.cliente;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

public class ClienteDAOHibernate implements ClienteDAO {
	
	private Session session;
	
	
	public void setSession(Session session) {
		this.session = session;
	}

	public void salvar(Cliente user) {
		session.save(user);
		
	}

	public void delete(Cliente user) {
		session.delete(user);
	}

	public void alter(Cliente user) {
		session.update(user);
		
	}

	public Cliente getById(Integer idCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	public Cliente getByCpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	public Cliente getByNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Cliente> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	public List consultaTodosClientes() {
		Criteria crit = session.createCriteria(Cliente.class);
		crit.setMaxResults(15);
		return crit.list();
	}
	
	

}
