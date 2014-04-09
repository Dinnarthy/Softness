package br.com.softness.cliente;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="cliente")
public class Cliente {
	
	@Id
	@GeneratedValue
	private Integer idCliente;
	
	@Column(name="nome", nullable=false)
	private String nome;
	
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="rg")
	private String rg;
	
	@Column(name="orgao_emissor")
	private String orgaoEmissor;
	
	@Column(name="sexo")
	private String sexo;
	
	@Column(name="estado_civil")
	private String estadoCivil;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_nascimento")
	private Date dataNacimento;
	
	@Column(name="numero_residencial")
	private String numeroResidencialString;
	
	@Column(name="numero_celular1")
	private String numeroCelular1;
	
	@Column(name="numero_celular2")
	private String numeroCelular2;
	
	@Column(name="email")
	private String email;
	
	
	

}
