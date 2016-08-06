/**
 * 
 */
package br.com.informati.restaurantes.http;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.informati.restaurantes.modelo.UsuarioEntity;

/**
 * @author Flavius
 *
 */
@XmlRootElement
public class UsuarioHttp extends GenericoHttp {

	
	private int id;
	private String nome;
	private String email;
	private String senha;
	private PerfilHttp perfil;
	
	public static UsuarioHttp converterEntity(UsuarioEntity entidade){
		
		UsuarioHttp usuario = new UsuarioHttp();
		
		usuario.setId(entidade.getId());
		usuario.setEmail(entidade.getEmail());
		usuario.setNome(entidade.getNome());
		usuario.setSenha(entidade.getSenha());
		usuario.setPerfil(PerfilHttp.converterEntity(entidade.getPerfil()));
		
		usuario.setIdUsuario(entidade.getIdUsuario());
		usuario.setUltimaAtualizacao(entidade.getUltimaAtualizacao());
		
		return usuario;
		
	}
	
	
	/**
	 * @param ultimaAtualizacao
	 * @param idUsuario
	 * @param id
	 * @param nome
	 * @param email
	 * @param senha
	 * @param perfil
	 * @param ultimaAtualizacao
	 * @param idUsuario
	 */
	public UsuarioHttp(int id, String nome, String email, String senha, PerfilHttp perfil, Date ultimaAtualizacao, int idUsuario) {
		super(ultimaAtualizacao, idUsuario);
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.perfil = perfil;
	}
	
	
	/**
	 * @param ultimaAtualizacao
	 * @param idUsuario
	 * @param id
	 * @param nome
	 * @param email
	 * @param senha
	 * @param perfil
	 */
	public UsuarioHttp(Date ultimaAtualizacao, int idUsuario, int id, String nome, String email, String senha,
			PerfilHttp perfil) {
		super(ultimaAtualizacao, idUsuario);
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.perfil = perfil;
	}

	
	/**
	 * 
	 */
	public UsuarioHttp() {
		super();
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
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
	public PerfilHttp getPerfil() {
		return perfil;
	}
	/**
	 * @param perfil the perfil to set
	 */
	public void setPerfil(PerfilHttp perfil) {
		this.perfil = perfil;
	}
	
}
