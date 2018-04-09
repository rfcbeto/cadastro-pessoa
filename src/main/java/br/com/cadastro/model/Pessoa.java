package br.com.cadastro.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PESSOA")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 2319342040284124333L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CODIGO")
	private long id;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "DATA_NASCIMENTO")
	private Date dataNascimento;

	@Column(name = "CPF")
	private String cpf;

	@Column(name = "ESTADO_CIVIL")
	private String estadoCivil;

	@Column(name = "REGISTRO_GERAL")
	private String rg;

	@Column(name = "SEXO")
	private String sexo;

	@OneToMany(fetch=FetchType.EAGER, mappedBy="pessoa", cascade=CascadeType.ALL)
	private List<Endereco> endereco;

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + "\nnome=" + nome + "\ndataNascimento=" + dataNascimento + "\ncpf=" + cpf
				+ "\nestadoCivil=" + estadoCivil + "\nrg=" + rg + "\nsexo=" + sexo + "\nEndereco=" + endereco + "]";
	}
}
