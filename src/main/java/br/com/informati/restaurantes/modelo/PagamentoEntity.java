/**
 * 
 */
package br.com.informati.restaurantes.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Flavius
 *
 */
@Entity
@Table(name="tb_pagamento")
public class PagamentoEntity extends GenericoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "valor")
	private double valor;
	
	@ManyToOne
	@JoinColumn(name="idPedido")
	private PedidoEntity pedido;
		
	@ManyToOne
	@JoinColumn(name="idFormaPagamento")
	private FormaPagamentoEntity formaPagamento;

	/**
	 * 
	 */
	public PagamentoEntity() {
		super();
	}

	/**
	 * @param id
	 * @param valor
	 * @param pedido
	 * @param formaPagamento
	 */
	public PagamentoEntity(Integer id, double valor, PedidoEntity pedido, FormaPagamentoEntity formaPagamento) {
		super();
		this.id = id;
		this.valor = valor;
		this.pedido = pedido;
		this.formaPagamento = formaPagamento;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the valor
	 */
	public double getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}

	/**
	 * @return the pedido
	 */
	public PedidoEntity getPedido() {
		return pedido;
	}

	/**
	 * @param pedido the pedido to set
	 */
	public void setPedido(PedidoEntity pedido) {
		this.pedido = pedido;
	}

	/**
	 * @return the formaPagamento
	 */
	public FormaPagamentoEntity getFormaPagamento() {
		return formaPagamento;
	}

	/**
	 * @param formaPagamento the formaPagamento to set
	 */
	public void setFormaPagamento(FormaPagamentoEntity formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
}
