package br.com.softness.cliente;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.softness.endereco.Endereco;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue
	private Integer idCliente;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "rg")
	private String rg;

	@Column(name = "orgao_emissor")
	private String orgaoEmissor;

	@Column(name = "sexo")
	private String sexo;

	@Column(name = "estado_civil")
	private String estadoCivil;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento")
	private Date dataNacimento;

	@Column(name = "numero_residencial")
	private String numeroResidencial;

	@Column(name = "numero_celular1")
	private String numeroCelular1;

	@Column(name = "numero_celular2")
	private String numeroCelular2;

	@Column(name = "email")
	private String email;

	@OneToOne
	@JoinColumn(name = "endereco_id")
	Endereco endereco;

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getOrgaoEmissor() {
		return orgaoEmissor;
	}

	public void setOrgaoEmissor(String orgaoEmissor) {
		this.orgaoEmissor = orgaoEmissor;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Date getDataNacimento() {
		return dataNacimento;
	}

	public void setDataNacimento(Date dataNacimento) {
		this.dataNacimento = dataNacimento;
	}

	public String getNumeroResidencialString() {
		return numeroResidencial;
	}

	public void setNumeroResidencialString(String numeroResidencialString) {
		this.numeroResidencial = numeroResidencialString;
	}

	public String getNumeroCelular1() {
		return numeroCelular1;
	}

	public void setNumeroCelular1(String numeroCelular1) {
		this.numeroCelular1 = numeroCelular1;
	}

	public String getNumeroCelular2() {
		return numeroCelular2;
	}

	public void setNumeroCelular2(String numeroCelular2) {
		this.numeroCelular2 = numeroCelular2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idCliente == null) ? 0 : idCliente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (idCliente == null) {
			if (other.idCliente != null)
				return false;
		} else if (!idCliente.equals(other.idCliente))
			return false;
		return true;
	}
	
	
	
	

}
