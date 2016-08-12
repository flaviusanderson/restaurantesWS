/**
 * 
 */
package br.com.informati.restaurantes.http;

import java.util.Date;

import br.com.informati.restaurantes.modelo.MesaEntity;

/**
 * @author Flavius
 *
 */
public class MesaHttp extends GenericoHttp {

	private int id;
	private String numero;
	private String descricao;
	
	public static MesaHttp converterEntity(MesaEntity entidade){
		
		MesaHttp mesa = new MesaHttp();
		
		mesa.setId(entidade.getId());
		mesa.setNumero(entidade.getNumero());
		mesa.setDescricao(entidade.getDescricao());
		mesa.setIdUsuario(entidade.getIdUsuario());
		mesa.setUltimaAtualizacao(entidade.getUltimaAtualizacao());
		
		return mesa;
		
	}
	
	/**
	 * @param ultimaAtualizacao
	 * @param idUsuario
	 * @param id
	 * @param numero
	 * @param descricao
	 */
	public MesaHttp(Date ultimaAtualizacao, int idUsuario, int id, String numero, String descricao) {
		super(ultimaAtualizacao, idUsuario);
		this.id = id;
		this.numero = numero;
		this.descricao = descricao;
	}

	/**
	 * 
	 */
	public MesaHttp() {
		super();
	}

	/**
	 * @param ultimaAtualizacao
	 * @param idUsuario
	 */
	public MesaHttp(Date ultimaAtualizacao, int idUsuario) {
		super(ultimaAtualizacao, idUsuario);
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
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
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

	
	
}
