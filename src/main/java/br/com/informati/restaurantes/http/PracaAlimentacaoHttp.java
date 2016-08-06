/**
 * 
 */
package br.com.informati.restaurantes.http;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.informati.restaurantes.modelo.PracaAlimentacaoEntity;
import br.com.informati.restaurantes.modelo.ProdutoEntity;
import br.com.informati.restaurantes.modelo.RestauranteEntity;

/**
 * @author Flavius
 *
 */
public class PracaAlimentacaoHttp extends GenericoHttp {

	private int id;
	private String nome;
	private List<RestauranteHttp> restaurantes;
	
	public static PracaAlimentacaoHttp converterEntity(PracaAlimentacaoEntity entidade){
		
		PracaAlimentacaoHttp praca = new PracaAlimentacaoHttp();
		
		praca.setId(entidade.getId());
		praca.setNome(entidade.getNome());
		praca.setIdUsuario(entidade.getIdUsuario());
		praca.setUltimaAtualizacao(entidade.getUltimaAtualizacao());
		
		List<RestauranteHttp> listaAux = new ArrayList<RestauranteHttp>();
		
		for(RestauranteEntity restaurante : entidade.getRestaurantes()){
			
			RestauranteHttp aux = new RestauranteHttp();
			
			aux = RestauranteHttp.converterEntity(restaurante);
			
			listaAux.add(aux);
			
		}
		
		praca.setRestaurantes(listaAux);
		
		return praca;
	}
	
	/**
	 * 
	 */
	public PracaAlimentacaoHttp() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param ultimaAtualizacao
	 * @param idUsuario
	 */
	public PracaAlimentacaoHttp(Date ultimaAtualizacao, int idUsuario) {
		super(ultimaAtualizacao, idUsuario);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param ultimaAtualizacao
	 * @param idUsuario
	 * @param id
	 * @param nome
	 * @param restaurantes
	 */
	public PracaAlimentacaoHttp(Date ultimaAtualizacao, int idUsuario, int id, String nome,
			List<RestauranteHttp> restaurantes) {
		super(ultimaAtualizacao, idUsuario);
		this.id = id;
		this.nome = nome;
		this.restaurantes = restaurantes;
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
	 * @return the restaurantes
	 */
	public List<RestauranteHttp> getRestaurantes() {
		return restaurantes;
	}
	/**
	 * @param restaurantes the restaurantes to set
	 */
	public void setRestaurantes(List<RestauranteHttp> restaurantes) {
		this.restaurantes = restaurantes;
	}
	
	
	
}
