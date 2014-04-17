package br.com.softness.endereco;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.softness.cliente.Cliente;

@Entity
@Table(name = "endereco")
public class Endereco {

	@Id
	@GeneratedValue
	private Integer idEndereco;

	@Column(name = "cep")
	private Integer cep;

	@Column(name = "estado")
	private String estado;

	@Column(name = "cidade")
	private String cidade;

	@Column(name = "bairro")
	private String bairro;

	@Column(name = "tipo_logradouro")
	private String tipoLogradouro;

	@Column(name = "logradouro")
	private String logradouro;

	@Column(name = "numero")
	private String numero;
	
	@OneToOne(mappedBy="endereco")
	private Cliente cliente;

	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}

	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	

}
