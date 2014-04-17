package br.com.softness.cliente;

import br.com.softness.util.HibernateUtil;

public class ClienteDAOFactory {
	
	public static ClienteDAO criarClienteDAO(){
		ClienteDAOHibernate clienteDAO = new ClienteDAOHibernate();
		clienteDAO.setSession(HibernateUtil.getSf().getCurrentSession());
		return clienteDAO;
		
	}

}
