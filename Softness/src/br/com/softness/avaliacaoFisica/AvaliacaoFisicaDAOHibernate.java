package br.com.softness.avaliacaoFisica;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.softness.cliente.Cliente;

public class AvaliacaoFisicaDAOHibernate implements AvaliacaoFisicaDAO {
	
	
	private Session session;
	
	

	

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public List consultaTodasAvaliacoesFisica() {
		// TODO Auto-generated method stub
		return null;
	}

	public void salvar(AvaliacaoFisica user) {
		session.save(user);
		System.out.print("\n Passou pelo salvar AvaliacaoFisicaDAOHibernate \n");
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
	return null;	
	}
	
	
	
	
	

	public List<AvaliacaoFisica> listarAvaliacaoFisicaByNome(Integer idCliente) {
		List<AvaliacaoFisica> resultado = new ArrayList<AvaliacaoFisica>();
		Criteria crit = session.createCriteria(AvaliacaoFisica.class);
		crit.add(Restrictions.eq("cliente", idCliente));
		return resultado;
		
	}
	
	
	public List<AvaliacaoFisica> listarAvaliacaoFisicaByNome2() {
		Criteria c1 = session.createCriteria(AvaliacaoFisica.class);  
		Criteria c = c1.createCriteria("cliente");  
		c.add(Restrictions.eq("idCliente", 2));  
		return c.list();
	}
	
	

	public List<AvaliacaoFisica> listarAvaliacaoFisicaByCpf(String campoPesquisa) {
		Criteria crit = session.createCriteria(AvaliacaoFisica.class);
		Criteria crit2 = crit.createCriteria("cliente");
		crit2.setProjection(Projections.projectionList().add(   
		Projections.distinct(Projections.property("cliente.cpf"))))
		.add(Restrictions.eq("cpf", campoPesquisa));
		
		return crit2.list();
	}

	public List<AvaliacaoFisica> listarTodos() {
		Criteria crit = session.createCriteria(AvaliacaoFisica.class);
		
		return crit.list();
		
	}

}
