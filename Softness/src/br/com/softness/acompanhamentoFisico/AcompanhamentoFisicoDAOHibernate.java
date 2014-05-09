package br.com.softness.acompanhamentoFisico;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.softness.avaliacaoFisica.AvaliacaoFisica;

public class AcompanhamentoFisicoDAOHibernate implements
		AcompanhamentoFisicoDAO {
	
	Session session;
	
	

	

	public void setSession(Session session) {
		this.session = session;
	}

	public void salvar(AcompanhamentoFisico acompanhamentoFisico) {
		session.save(acompanhamentoFisico);

	}

	public void delete(AcompanhamentoFisico acompanhamentoFisico) {
		session.delete(acompanhamentoFisico);

	}

	public void alter(AcompanhamentoFisico acompanhamentoFisico) {
		session.merge(acompanhamentoFisico);

	}

	public List<AcompanhamentoFisico> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	

	public List<AcompanhamentoFisico> listarAcompnhamentoFisicoByIdAvaliacao(
			Integer campoPesquisa) {
		Criteria crit = session.createCriteria(AcompanhamentoFisico.class);
		Criteria crit2 = crit.createCriteria("avaliacaoFisica");
		crit2.add(Restrictions.eq("idAvaliacaoFisica", campoPesquisa));
		
		return crit2.list();
	}

	public List<AcompanhamentoFisico> listarAcompanhamentoFisicoByData(Date data) {
		Criteria crit = session.createCriteria(AcompanhamentoFisico.class);
		crit.add(Restrictions.eq("data", data));
		return crit.list();
	}
	
	

	

}
