package br.com.softness.acompanhamentoFisico;

import java.util.Date;






import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.softness.avaliacaoFisica.AvaliacaoFisica;





@Entity
@Table(name="acompanhamento_fisico")
public class AcompanhamentoFisico  {
	
	

	@Id
	@GeneratedValue
	private Integer idAcompanhamentoFisico;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="avaliacao_id")
	private AvaliacaoFisica avaliacaoFisica;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date")
	private Date data = new Date();
	
	@Column(name="peso")
	private String peso;
	
	@Column(name="altura")
	private String altura;
	
	@Column(name="cintura")
	private String cintura;
	
	@Column(name="pescoco")
	private String pescoco;
	
	@Column(name="quadril")
	private String quadril;
	
	@Column(name="taxa_gordura")
	private String taxaGordura;
	
	@Column(name="imc")
	private String imc;
	
	@Column(name="situacao_imc")
	private String situacaoImc;

	
	
	
	
	

	

	public Integer getIdAcompanhamentoFisico() {
		return idAcompanhamentoFisico;
	}

	public void setIdAcompanhamentoFisico(Integer idAcompanhamentoFisico) {
		this.idAcompanhamentoFisico = idAcompanhamentoFisico;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getCintura() {
		return cintura;
	}

	public void setCintura(String cintura) {
		this.cintura = cintura;
	}

	public String getPescoco() {
		return pescoco;
	}

	public void setPescoco(String pescoco) {
		this.pescoco = pescoco;
	}

	public String getQuadril() {
		return quadril;
	}

	public void setQuadril(String quadril) {
		this.quadril = quadril;
	}

	public String getTaxaGordura() {
		return taxaGordura;
	}

	public void setTaxaGordura(String taxaGordura) {
		this.taxaGordura = taxaGordura;
	}

	public String getImc() {
		return imc;
	}

	public void setImc(String imc) {
		this.imc = imc;
	}

	public String getSituacaoImc() {
		return situacaoImc;
	}

	public void setSituacaoImc(String situacaoImc) {
		this.situacaoImc = situacaoImc;
	}

	public AvaliacaoFisica getAvaliacaoFisica() {
		return avaliacaoFisica;
	}

	public void setAvaliacaoFisica(AvaliacaoFisica avaliacaoFisica) {
		this.avaliacaoFisica = avaliacaoFisica;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((idAcompanhamentoFisico == null) ? 0
						: idAcompanhamentoFisico.hashCode());
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
		AcompanhamentoFisico other = (AcompanhamentoFisico) obj;
		if (idAcompanhamentoFisico == null) {
			if (other.idAcompanhamentoFisico != null)
				return false;
		} else if (!idAcompanhamentoFisico.equals(other.idAcompanhamentoFisico))
			return false;
		return true;
	}
}
	
	

	
