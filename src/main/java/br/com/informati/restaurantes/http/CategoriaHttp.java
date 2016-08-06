/**
 * 
 */
package br.com.informati.restaurantes.http;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.informati.restaurantes.modelo.CategoriaEntity;
import br.com.informati.restaurantes.modelo.ProdutoEntity;

/**
 * @author Flavius
 *
 */
public class CategoriaHttp extends GenericoHttp {

	private int id;
	private String nome;
	private RestauranteHttp restaurante;
	private List<ProdutoHttp> produtos;
	
	public static CategoriaHttp converterEntity(CategoriaEntity entidade){
		
		CategoriaHttp categoria = new CategoriaHttp();
		
		categoria.setId(entidade.getId());
		
		categoria.setNome(entidade.getNome());
		categoria.setRestaurante(RestauranteHttp.converterEntity(entidade.getRestaurante()));
		categoria.setIdUsuario(entidade.getIdUsuario());
		categoria.setUltimaAtualizacao(entidade.getUltimaAtualizacao());
		
		List<ProdutoHttp> listaAux = new ArrayList<ProdutoHttp>();
		for(ProdutoEntity produto : entidade.getProdutos()){
			
			ProdutoHttp aux = new ProdutoHttp();
			
			aux = ProdutoHttp.converterEntity(produto);
			
			listaAux.add(aux);
			
		}
		
		categoria.setProdutos(listaAux);
		
		
		return categoria;
		
	}
	
	/**
	 * 
	 */
	public CategoriaHttp() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param ultimaAtualizacao
	 * @param idUsuario
	 */
	public CategoriaHttp(Date ultimaAtualizacao, int idUsuario) {
		super(ultimaAtualizacao, idUsuario);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param ultimaAtualizacao
	 * @param idUsuario
	 * @param id
	 * @param nome
	 * @param restaurante
	 * @param pedidos
	 */
	public CategoriaHttp(Date ultimaAtualizacao, int idUsuario, int id, String nome, RestauranteHttp restaurante,
			List<ProdutoHttp> produtos) {
		super(ultimaAtualizacao, idUsuario);
		this.id = id;
		this.nome = nome;
		this.restaurante = restaurante;
		this.produtos = produtos;
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
	 * @return the restaurante
	 */
	public RestauranteHttp getRestaurante() {
		return restaurante;
	}
	/**
	 * @param restaurante the restaurante to set
	 */
	public void setRestaurante(RestauranteHttp restaurante) {
		this.restaurante = restaurante;
	}
	/**
	 * @return the pedidos
	 */
	public List<ProdutoHttp> getProdutos() {
		return produtos;
	}
	/**
	 * @param pedidos the pedidos to set
	 */
	public void setProdutos(List<ProdutoHttp> produtos) {
		this.produtos = produtos;
	}
	
	
}
