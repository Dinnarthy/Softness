package br.com.softness.avaliacaoFisica;

import br.com.softness.util.HibernateUtil;

public class AvaliacaoFisicaDAOFactory {
	
	public static AvaliacaoFisicaDAO criarAvaliacaoFisicaDAO(){
		
		AvaliacaoFisicaDAOHibernate avaliacaoFisicaDAO = new AvaliacaoFisicaDAOHibernate();
		avaliacaoFisicaDAO.setSession(HibernateUtil.getSf().getCurrentSession());
		System.out.print("Passou pelo criarAvaliacaoFisicaDAO");
		return avaliacaoFisicaDAO;
		
		
		
		
	}

}
