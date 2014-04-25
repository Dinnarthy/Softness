package br.com.softness.avaliacaoFisica;

import java.util.List;

import org.hibernate.Session;

import br.com.softness.cliente.Cliente;

public class AvaliacaoFisicaDAOHibernate implements AvaliacaoFisicaDAO {
	
	
	private Session session;
	
	

	

	public void setSession(Session session) {
		this.session = session;
	}

	public List consultaTodasAvaliacoesFisica() {
		// TODO Auto-generated method stub
		return null;
	}

	public void salvar(AvaliacaoFisica user) {
		session.save(user);

	}

	public void delete(AvaliacaoFisica user) {
		session.delete(user);

	}

	public void alter(AvaliacaoFisica user) {
		session.update(user);

	}

	public AvaliacaoFisica getById(Integer idAvaliacaoFisica) {
		// TODO Auto-generated method stub
		return null;
	}

	public AvaliacaoFisica getByCpf(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public AvaliacaoFisica getByNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AvaliacaoFisica> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
