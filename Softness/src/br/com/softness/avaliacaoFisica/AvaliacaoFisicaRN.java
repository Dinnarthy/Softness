package br.com.softness.avaliacaoFisica;

import java.util.List;



public class AvaliacaoFisicaRN {

	private AvaliacaoFisicaDAO avaliacaoFisicaDAO;

	public AvaliacaoFisicaRN() {
		avaliacaoFisicaDAO = AvaliacaoFisicaDAOFactory
				.criarAvaliacaoFisicaDAO();
	}

	public AvaliacaoFisica getById(Integer idAvaliacaoFisica) {

		return avaliacaoFisicaDAO.getById(idAvaliacaoFisica);

	}

	public AvaliacaoFisica getByNome(String nome) {

		return avaliacaoFisicaDAO.getByNome(nome);
	}

	public AvaliacaoFisica getByCpf(String cpf) {
		return avaliacaoFisicaDAO.getByCpf(cpf);
	}

	public void salvar(AvaliacaoFisica avaliacaoFisica) {

		//Integer idAvalicaoFisica = avaliacaoFisica.getIdAvaliacaoFisica();

	//	if (idAvalicaoFisica == null) {
			avaliacaoFisicaDAO.salvar(avaliacaoFisica);
			System.out.print("CLienteRN idAvaliacaoFisica = 0 ou = NULL");
		//} else {
		//	avaliacaoFisicaDAO.alter(avaliacaoFisica);
		//	System.out.print("CLienteRN idCliente <> 0 ou <> NULL");
		//}

	}
	
	public List<AvaliacaoFisica> listarAvaliacaoFisicaByNome() {
		return avaliacaoFisicaDAO.listarAvaliacaoFisicaByNome2();
	}
	
	public List<AvaliacaoFisica> listarAvaliacaoFisicaByCpf(){
		return avaliacaoFisicaDAO.listarAvaliacaoFisicaByCpf();
	}
}
