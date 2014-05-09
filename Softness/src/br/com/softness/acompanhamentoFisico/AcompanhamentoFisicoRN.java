package br.com.softness.acompanhamentoFisico;

import java.util.Date;
import java.util.List;

import br.com.softness.avaliacaoFisica.AvaliacaoFisica;

public class AcompanhamentoFisicoRN {
	
	AcompanhamentoFisicoDAO acompanhamentoFisicoDAO;

	public AcompanhamentoFisicoRN() {
		acompanhamentoFisicoDAO = AcompanhamentoFisicoDAOFactory.criarAcompanhamentoFisicoDAO();
	}
	
	public void salvar(AcompanhamentoFisico acompanhamentoFisico) {
		
		Integer idAcompanhamentoFisico = acompanhamentoFisico.getIdAcompanhamentoFisico();
		if(idAcompanhamentoFisico==null){
			acompanhamentoFisicoDAO.salvar(acompanhamentoFisico);
		System.out.print("CLienteRN idCliente = 0 ou = NULL");
		}else{
			acompanhamentoFisicoDAO.alter(acompanhamentoFisico);
		System.out.print("CLienteRN idCliente <> 0 ou <> NULL");
		}

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
	
	public List<AcompanhamentoFisico>listarAcompanhamentoFisicoByData(Date data){
		return acompanhamentoFisicoDAO.listarAcompanhamentoFisicoByData(data);
	}
	
	

}
