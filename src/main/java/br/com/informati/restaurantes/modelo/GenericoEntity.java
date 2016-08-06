/**
 * 
 */
package br.com.informati.restaurantes.modelo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author Flavius
 *
 */
@MappedSuperclass
public abstract class GenericoEntity {

	/**
	 * Estes informações servem para garantir a integridade nas transações, tanto em relação ao último momento de atualização do registro,
	 * quanto do usuário do sistema que realiza a operação
	 * 
	 */
	@Column(name="ultimaAtualizacao")
	private Timestamp ultimaAtualizacao;
	
	@Column(name = "idUsuario")
	private Integer idUsuario;

	/**
	 * @return the ultimaAtualizacao
	 */
	public Timestamp getUltimaAtualizacao() {
		return ultimaAtualizacao;
	}

	/**
	 * @param ultimaAtualizacao the ultimaAtualizacao to set
	 */
	public void setUltimaAtualizacao(Timestamp ultimaAtualizacao) {
		this.ultimaAtualizacao = ultimaAtualizacao;
	}

	/**
	 * @return the idUsuario
	 */
	public Integer getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
}
