/**
 * 
 */
package br.com.informati.restaurantes.modelo;

import java.sql.Timestamp;

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
@Table(name="tb_usuario")
public class UsuarioEntity extends GenericoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@Column(name="nome")
	private String nome;
	
	@Column(name="email")
	private String email;
	
	@Column(name="senha")
	private String senha;
	
	
	/**
	 * Mapeamento com o perfil do usuário
	 */
	@ManyToOne
	@JoinColumn(name="idPerfil")
	private PerfilEntity perfil;


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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}


	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}


	/**
	 * @return the perfil
	 */
	public PerfilEntity getPerfil() {
		return perfil;
	}


	/**
	 * @param perfil the perfil to set
	 */
	public void setPerfil(PerfilEntity perfil) {
		this.perfil = perfil;
	}
	

	public UsuarioEntity(){
		
	}
}
