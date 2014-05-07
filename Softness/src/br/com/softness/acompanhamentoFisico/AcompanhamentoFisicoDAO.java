package br.com.softness.acompanhamentoFisico;

import java.util.List;



public interface AcompanhamentoFisicoDAO {
	
	public void salvar(AcompanhamentoFisico acompanhamentoFisico);
	
	public void delete(AcompanhamentoFisico acompanhamentoFisico);
	
	public void alter(AcompanhamentoFisico acompanhamentoFisico);
	
	public List<AcompanhamentoFisico>listarTodos();
	
	public List<AcompanhamentoFisico> listarAcompnhamentoFisicoByIdAvaliacao(Integer campoPesquisa);
	
	

}
