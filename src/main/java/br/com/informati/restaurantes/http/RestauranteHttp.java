/**
 * 
 */
package br.com.informati.restaurantes.http;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import br.com.informati.restaurantes.modelo.CategoriaEntity;
import br.com.informati.restaurantes.modelo.RestauranteEntity;

/**
 * @author Flavius
 *
 */
public class RestauranteHttp extends GenericoHttp {

	private int id;
	private String nome;
	private String nomeFantasia;
	private String razaoSocial;
	private String cnpj;
	private String endereco;
	private String telefone;
	private List<CategoriaHttp> categorias;
	private PracaAlimentacaoHttp pracaAlimentacao;
	
	public static RestauranteHttp converterEntity (RestauranteEntity entidade){
		
		RestauranteHttp restaurante = new RestauranteHttp();
		
		restaurante.setId(entidade.getId());
		restaurante.setNome(entidade.getNome());
		restaurante.setNomeFantasia(entidade.getNomeFantasia());
		restaurante.setRazaoSocial(entidade.getRazaoSocial());
		restaurante.setCnpj(entidade.getCnpj());
		restaurante.setEndereco(entidade.getEndereco());
		restaurante.setTelefone(entidade.getTelefone());
		restaurante.setPracaAlimentacao(PracaAlimentacaoHttp.converterEntity(entidade.getPracaAlimentacao()));
		
		restaurante.setIdUsuario(entidade.getIdUsuario());
		restaurante.setUltimaAtualizacao(entidade.getUltimaAtualizacao());
		
		List<CategoriaHttp> listaAux = new ArrayList<CategoriaHttp>();
		
		for(CategoriaEntity categoria : entidade.getCategorias()){
			
			CategoriaHttp aux = new CategoriaHttp();
			
			aux = CategoriaHttp.converterEntity(categoria);
			
			listaAux.add(aux);
			
		}
		
		restaurante.setCategorias(listaAux);
		
		return restaurante;
		
	}
	/**
	 * 
	 */
	public RestauranteHttp() {
		super();
	}
	/**
	 * @param ultimaAtualizacao
	 * @param idUsuario
	 */
	public RestauranteHttp(Date ultimaAtualizacao, int idUsuario) {
		super(ultimaAtualizacao, idUsuario);
	}
	/**
	 * @param ultimaAtualizacao
	 * @param idUsuario
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
	public RestauranteHttp(Date ultimaAtualizacao, int idUsuario, int id, String nome, String nomeFantasia,
			String razaoSocial, String cnpj, String endereco, String telefone, List<CategoriaHttp> categorias,
			PracaAlimentacaoHttp pracaAlimentacao) {
		super(ultimaAtualizacao, idUsuario);
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
	public List<CategoriaHttp> getCategorias() {
		return categorias;
	}
	/**
	 * @param categorias the categorias to set
	 */
	public void setCategorias(List<CategoriaHttp> categorias) {
		this.categorias = categorias;
	}
	/**
	 * @return the pracaAlimentacao
	 */
	public PracaAlimentacaoHttp getPracaAlimentacao() {
		return pracaAlimentacao;
	}
	/**
	 * @param pracaAlimentacao the pracaAlimentacao to set
	 */
	public void setPracaAlimentacao(PracaAlimentacaoHttp pracaAlimentacao) {
		this.pracaAlimentacao = pracaAlimentacao;
	}
	
	
}
