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
@Table(name = "tb_item_pedido")
public class ItemPedidoEntity extends GenericoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nome")
	private String nome;
	
	@Column(name = "precoUnitario")
	private double precoUnitario;
	
	@Column(name = "quantidade")
	private int quantidade;
	
	@ManyToOne
	@JoinColumn(name = "idPedido")
	private PedidoEntity pedido;
	
	@ManyToOne
	@JoinColumn(name = "idProduto")
	private ProdutoEntity produto;

	/**
	 * 
	 */
	public ItemPedidoEntity() {
		super();
	}

	/**
	 * @param id
	 * @param nome
	 * @param precoUnitario
	 * @param quantidade
	 * @param pedido
	 * @param produto
	 */
	public ItemPedidoEntity(Integer id, String nome, double precoUnitario, int quantidade, PedidoEntity pedido,
			ProdutoEntity produto) {
		super();
		this.id = id;
		this.nome = nome;
		this.precoUnitario = precoUnitario;
		this.quantidade = quantidade;
		this.pedido = pedido;
		this.produto = produto;
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

	/**
	 * @return the precoUnitario
	 */
	public double getPrecoUnitario() {
		return precoUnitario;
	}

	/**
	 * @param precoUnitario the precoUnitario to set
	 */
	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	/**
	 * @return the quantidade
	 */
	public int getQuantidade() {
		return quantidade;
	}

	/**
	 * @param quantidade the quantidade to set
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
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
	 * @return the produto
	 */
	public ProdutoEntity getProduto() {
		return produto;
	}

	/**
	 * @param produto the produto to set
	 */
	public void setProduto(ProdutoEntity produto) {
		this.produto = produto;
	}
	
}
