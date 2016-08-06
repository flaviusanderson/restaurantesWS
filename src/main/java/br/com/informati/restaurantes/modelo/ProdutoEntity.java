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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Flavius
 *
 */
@Entity
@Table(name = "tb_produto")
public class ProdutoEntity extends GenericoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nome")
	private String nome;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "preco")
	private double preco;
	
	@Column(name = "qtd_estoque")
	private int quantidade;
	
	@OneToMany(mappedBy = "produto", targetEntity = ItemPedidoEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ItemPedidoEntity> itens;
	
	@ManyToOne
	@JoinColumn(name = "idCategoria")
	private CategoriaEntity categoria;

	/**
	 * 
	 */
	public ProdutoEntity() {
		super();
	}

	/**
	 * @param id
	 * @param nome
	 * @param descricao
	 * @param preco
	 * @param quantidade
	 * @param itens
	 * @param categoria
	 */
	public ProdutoEntity(Integer id, String nome, String descricao, double preco, int quantidade,
			List<ItemPedidoEntity> itens, CategoriaEntity categoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.quantidade = quantidade;
		this.itens = itens;
		this.categoria = categoria;
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
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the preco
	 */
	public double getPreco() {
		return preco;
	}

	/**
	 * @param preco the preco to set
	 */
	public void setPreco(double preco) {
		this.preco = preco;
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
	 * @return the itens
	 */
	public List<ItemPedidoEntity> getItens() {
		return itens;
	}

	/**
	 * @param itens the itens to set
	 */
	public void setItens(List<ItemPedidoEntity> itens) {
		this.itens = itens;
	}

	/**
	 * @return the categoria
	 */
	public CategoriaEntity getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(CategoriaEntity categoria) {
		this.categoria = categoria;
	}
	
	
}
