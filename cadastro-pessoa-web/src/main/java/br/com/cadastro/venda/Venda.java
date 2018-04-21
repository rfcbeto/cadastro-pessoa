package br.com.cadastro.venda;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.cadastro.model.Pessoa;

@Entity
@Table(name="VENDA")
public class Venda implements Serializable{
	private static final long serialVersionUID = 8788260394521051720L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private long id;
	
	@Column(name="TOTAL_VENDA")
	private double totalVenda;
	
	/*
	 	private Produto produto;
	 	
		private Vendedor vendedor;
	
		private Cliente cliente;
	
		private TipoVenda tipoVenda;
	*/
	
	@ManyToOne(optional=false)
	@JoinColumn(name="pessoa_id", nullable=false, updatable=false)
	private Pessoa pessoa;
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Column(name="QUANTIDADE")
	private int quantidade;
	
	@Column(name="FORMA_PAGAMENTO")
	private String formaPagamento;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="DATA_VENDA")
	private Calendar dataVenda;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getTotalVenda() {
		return totalVenda;
	}

	public void setTotalVenda(double totalVenda) {
		this.totalVenda = totalVenda;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Calendar getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Calendar dataVenda) {
		this.dataVenda = dataVenda;
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", totalVenda=" + totalVenda + ", quantidade=" + quantidade + ", formaPagamento="
				+ formaPagamento + ", status=" + status + ", dataVenda=" + dataVenda + "]";
	}
}
