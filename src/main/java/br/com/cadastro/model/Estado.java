package br.com.cadastro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estado")
public class Estado implements Serializable{
	private static final long serialVersionUID = 384228454857707775L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CODIGO")
	private Integer id;
	
	@Column(name="ESTADO")
	private String nomeEstado;
	
	@Column(name="SIGLA")
	private String siglaEstado;
	
	@Column(name="ACPITAL")
	private String capital;
	
	@Column(name="REGIAO")
	private String regiao;

	
	public Estado() {
	}
	
	public Estado(Estado estado){
		this.id = estado.id; 
		this.capital = estado.capital;
		this.nomeEstado = estado.nomeEstado;
		this.siglaEstado =  estado.siglaEstado;
		this.regiao = estado.regiao;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomeEstado() {
		return nomeEstado;
	}
	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}
	public String getSiglaEstado() {
		return siglaEstado;
	}
	public void setSiglaEstado(String siglaEstado) {
		this.siglaEstado = siglaEstado;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getRegiao() {
		return regiao;
	}
	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}
	
	
	@Override
	public String toString() {
		return "Estado [id=" + id + ", nomeEstado=" + nomeEstado + ", siglaEstado=" + siglaEstado + ", capital="
				+ capital + ", regiao=" + regiao + "]";
	}
}
