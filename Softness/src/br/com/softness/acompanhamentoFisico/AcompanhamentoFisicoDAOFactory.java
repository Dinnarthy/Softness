package br.com.softness.acompanhamentoFisico;

import br.com.softness.util.HibernateUtil;

public class AcompanhamentoFisicoDAOFactory {
	
	public static AcompanhamentoFisicoDAO criarAcompanhamentoFisicoDAO(){
		AcompanhamentoFisicoDAOHibernate acompanhamentoFisicoDAO = new AcompanhamentoFisicoDAOHibernate();
		acompanhamentoFisicoDAO.setSession(HibernateUtil.getSf().getCurrentSession());
		System.out.print("Passou pelo criarAcompanhamentoFisicoDAO");
		return acompanhamentoFisicoDAO;
	}

}
