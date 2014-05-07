package br.com.softness.acompanhamentoFisico;

import java.util.List;

import br.com.softness.avaliacaoFisica.AvaliacaoFisica;

public class AcompanhamentoFisicoRN {
	
	AcompanhamentoFisicoDAO acompanhamentoFisicoDAO;

	public AcompanhamentoFisicoRN() {
		acompanhamentoFisicoDAO = AcompanhamentoFisicoDAOFactory.criarAcompanhamentoFisicoDAO();
	}
	
	public void salvar(AcompanhamentoFisico acompanhamentoFisico) {
		acompanhamentoFisicoDAO.salvar(acompanhamentoFisico);

	}
	
	public void delete(AcompanhamentoFisico acompanhamentoFisico) {
		acompanhamentoFisicoDAO.delete(acompanhamentoFisico);

	}
	

	
	public List<AcompanhamentoFisico> listarTodos() {
		return acompanhamentoFisicoDAO.listarTodos();
		
	}
	
	public List<AcompanhamentoFisico> listarAcompnhamentoFisicoByIdAvaliacao(
			Integer campoPesquisa) {
		
		return acompanhamentoFisicoDAO.listarAcompnhamentoFisicoByIdAvaliacao(campoPesquisa);
	}
	
	

}
