package br.com.softness.avaliacaoFisica;

import java.util.List;

import br.com.softness.cliente.Cliente;

public interface AvaliacaoFisicaDAO {
	
public List consultaTodasAvaliacoesFisica();
	
	public void salvar(AvaliacaoFisica avaliacaoFisica);
	
	public void delete(AvaliacaoFisica avaliacaoFisica);
	
	public void alter(AvaliacaoFisica avaliacaoFisica);
	
	public AvaliacaoFisica getById(Integer idAvaliacaoFisica);
	
	public AvaliacaoFisica getByCpf(String email);
	
	public AvaliacaoFisica getByNome(String nome);
	
	public List<AvaliacaoFisica>listar();

}
