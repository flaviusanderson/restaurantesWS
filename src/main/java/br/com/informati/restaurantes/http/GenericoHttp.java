/**
 * 
 */
package br.com.informati.restaurantes.http;

import java.util.Date;

/**
 * @author Flavius
 *
 */
public abstract class GenericoHttp {

	private Date ultimaAtualizacao;
	private int idUsuario;
	/**
	 * @return the idUsuario
	 */
	public int getIdUsuario() {
		return idUsuario;
	}
	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	/**
	 * @return the ultimaAtualizacao
	 */
	public Date getUltimaAtualizacao() {
		return ultimaAtualizacao;
	}
	/**
	 * @param ultimaAtualizacao the ultimaAtualizacao to set
	 */
	public void setUltimaAtualizacao(Date ultimaAtualizacao) {
		this.ultimaAtualizacao = ultimaAtualizacao;
	}
	/**
	 * @param ultimaAtualizacao
	 * @param idUsuario
	 */
	public GenericoHttp(Date ultimaAtualizacao, int idUsuario) {
		super();
		this.ultimaAtualizacao = ultimaAtualizacao;
		this.idUsuario = idUsuario;
	}
	
	public GenericoHttp(){}
	
	
}
