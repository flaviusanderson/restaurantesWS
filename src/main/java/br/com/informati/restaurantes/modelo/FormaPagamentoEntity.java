/**
 * 
 */
package br.com.informati.restaurantes.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Flavius
 *
 */
@Entity
@Table(name = "tb_forma_pagamento")
public class FormaPagamentoEntity extends GenericoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nome")
	private String nome;
	
	@OneToMany(mappedBy = "formaPagamento", targetEntity = PagamentoEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PagamentoEntity> pagamentos;

	/**
	 * 
	 */
	public FormaPagamentoEntity() {
		super();
	}

	/**
	 * @param id
	 * @param nome
	 * @param pagamentos
	 */
	public FormaPagamentoEntity(Integer id, String nome, List<PagamentoEntity> pagamentos) {
		super();
		this.id = id;
		this.nome = nome;
		this.pagamentos = pagamentos;
	}
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the pagamentos
	 */
	public List<PagamentoEntity> getPagamentos() {
		return pagamentos;
	}

	/**
	 * @param pagamentos the pagamentos to set
	 */
	public void setPagamentos(List<PagamentoEntity> pagamentos) {
		this.pagamentos = pagamentos;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
