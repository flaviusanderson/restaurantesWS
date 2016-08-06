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
@Table(name = "tb_praca_alimentacao")
public class PracaAlimentacaoEntity extends GenericoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nome")
	private String nome;
	
	@OneToMany(mappedBy = "pracaAlimentacao", targetEntity = RestauranteEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<RestauranteEntity> restaurantes;
	

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
	 * @return the restaurantes
	 */
	public List<RestauranteEntity> getRestaurantes() {
		return restaurantes;
	}

	/**
	 * @param restaurantes the restaurantes to set
	 */
	public void setRestaurantes(List<RestauranteEntity> restaurantes) {
		this.restaurantes = restaurantes;
	}

	/**
	 * @param id
	 * @param nome
	 * @param restaurantes
	 */
	public PracaAlimentacaoEntity(Integer id, String nome, List<RestauranteEntity> restaurantes) {
		super();
		this.id = id;
		this.nome = nome;
		this.restaurantes = restaurantes;
	}

	/**
	 * 
	 */
	public PracaAlimentacaoEntity() {
		super();
	}
	
	
}
