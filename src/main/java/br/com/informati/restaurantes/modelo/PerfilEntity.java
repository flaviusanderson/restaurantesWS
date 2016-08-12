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
@Table(name="tb_perfil")
public class PerfilEntity extends GenericoEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="nome")	
	private String  nome;
	
	@OneToMany(mappedBy = "perfil", targetEntity = UsuarioEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<UsuarioEntity> usuarios;

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
	 * @return the usuarios
	 */
	public List<UsuarioEntity> getUsuarios() {
		return usuarios;
	}

	/**
	 * @param usuarios the usuarios to set
	 */
	public void setUsuarios(List<UsuarioEntity> usuarios) {
		this.usuarios = usuarios;
	}

	/**
	 * @param id
	 * @param nome
	 */
	public PerfilEntity(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public PerfilEntity(){}
	
	
}
