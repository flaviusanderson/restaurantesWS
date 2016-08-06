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
@Table(name = "tb_restaurante")
public class RestauranteEntity extends GenericoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nome")
	private String nome;
	
	@Column(name = "nomeFantasia")
	private String nomeFantasia;
	
	@Column(name = "razaoSocial")
	private String razaoSocial;
	
	@Column(name = "cnpj")
	private String cnpj;
	
	@Column(name = "endereco")
	private String endereco;
	
	@Column(name = "telefone")
	private String telefone;
	
	@OneToMany(mappedBy = "restaurante", targetEntity = CategoriaEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<CategoriaEntity> categorias;
	
	@ManyToOne
	@JoinColumn(name = "idPracaAlimentacao")
	private PracaAlimentacaoEntity pracaAlimentacao;

	/**
	 * 
	 */
	public RestauranteEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param nome
	 * @param nomeFantasia
	 * @param razaoSocial
	 * @param cnpj
	 * @param endereco
	 * @param telefone
	 * @param categorias
	 * @param pracaAlimentacao
	 */
	public RestauranteEntity(Integer id, String nome, String nomeFantasia, String razaoSocial, String cnpj,
			String endereco, String telefone, List<CategoriaEntity> categorias,
			PracaAlimentacaoEntity pracaAlimentacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.nomeFantasia = nomeFantasia;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.telefone = telefone;
		this.categorias = categorias;
		this.pracaAlimentacao = pracaAlimentacao;
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
	 * @return the nomeFantasia
	 */
	public String getNomeFantasia() {
		return nomeFantasia;
	}

	/**
	 * @param nomeFantasia the nomeFantasia to set
	 */
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	/**
	 * @return the razaoSocial
	 */
	public String getRazaoSocial() {
		return razaoSocial;
	}

	/**
	 * @param razaoSocial the razaoSocial to set
	 */
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	/**
	 * @return the cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * @param cnpj the cnpj to set
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the categorias
	 */
	public List<CategoriaEntity> getCategorias() {
		return categorias;
	}

	/**
	 * @param categorias the categorias to set
	 */
	public void setCategorias(List<CategoriaEntity> categorias) {
		this.categorias = categorias;
	}

	/**
	 * @return the pracaAlimentacao
	 */
	public PracaAlimentacaoEntity getPracaAlimentacao() {
		return pracaAlimentacao;
	}

	/**
	 * @param pracaAlimentacao the pracaAlimentacao to set
	 */
	public void setPracaAlimentacao(PracaAlimentacaoEntity pracaAlimentacao) {
		this.pracaAlimentacao = pracaAlimentacao;
	}
	
	
}
