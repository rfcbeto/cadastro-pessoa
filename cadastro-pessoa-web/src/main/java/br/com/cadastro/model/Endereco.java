package br.com.cadastro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author roberto.coelho
 *
 */
@Entity
@Table(name="ENDERECO")
public class Endereco implements Serializable {

	
	private static final long serialVersionUID = -6990547493401069748L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private long id;
	
	@Column(name="CEP")
	private String cep;
	
	@Column(name="RUA")
	private String rua;
	
	@Column(name="NUMERO")
	private int numero;
	
	@Column(name="TIPO_ENDERECO")
	private int tipoEndereco;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="pessoa_id", nullable=false, updatable=false)
	private Pessoa pessoa;
	
	

	public int getTipoEndereco() {
		return tipoEndereco;
	}

	public void setTipoEndereco(int tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	private String bairro;
	
	private String municipio;
	
	private String complemento;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", cep=" + cep + ", rua=" + rua + ", numero=" + numero + ", pessoa=" + pessoa
				+ ", bairro=" + bairro + ", municipio=" + municipio + ", complemento=" + complemento + "]";
	}
}
