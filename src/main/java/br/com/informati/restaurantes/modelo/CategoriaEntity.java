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
@Table(name = "tb_categoria")
public class CategoriaEntity extends GenericoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nome")
	private String nome;

	@OneToMany(mappedBy = "categoria", targetEntity = ProdutoEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ProdutoEntity> produtos;
	
	@ManyToOne
	@JoinColumn(name = "idRestaurante")
	private RestauranteEntity restaurante;

	/**
	 * 
	 */
	public CategoriaEntity() {
		super();
	}

	/**
	 * @param id
	 * @param nome
	 * @param produtos
	 * @param restaurante
	 */
	public CategoriaEntity(Integer id, String nome, List<ProdutoEntity> produtos, RestauranteEntity restaurante) {
		super();
		this.id = id;
		this.nome = nome;
		this.produtos = produtos;
		this.restaurante = restaurante;
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
	 * @return the produtos
	 */
	public List<ProdutoEntity> getProdutos() {
		return produtos;
	}

	/**
	 * @param produtos the produtos to set
	 */
	public void setProdutos(List<ProdutoEntity> produtos) {
		this.produtos = produtos;
	}

	/**
	 * @return the restaurante
	 */
	public RestauranteEntity getRestaurante() {
		return restaurante;
	}

	/**
	 * @param restaurante the restaurante to set
	 */
	public void setRestaurante(RestauranteEntity restaurante) {
		this.restaurante = restaurante;
	}
	
	
}
