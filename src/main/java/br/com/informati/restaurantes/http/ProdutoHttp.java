/**
 * 
 */
package br.com.informati.restaurantes.http;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.informati.restaurantes.modelo.ItemPedidoEntity;
import br.com.informati.restaurantes.modelo.ProdutoEntity;

/**
 * @author Flavius
 *
 */
public class ProdutoHttp extends GenericoHttp {

	private int id;
	private String nome;
	private String descricao;
	private double preco;
	private int quantidade;
	private List<ItemPedidoHttp> itens;
	private CategoriaHttp categoria;

	public static ProdutoHttp converterEntity(ProdutoEntity entidade) {

		ProdutoHttp produto = new ProdutoHttp();

		produto.setId(entidade.getId());
		produto.setNome(entidade.getNome());
		produto.setDescricao(entidade.getDescricao());
		produto.setPreco(entidade.getPreco());
		produto.setQuantidade(entidade.getQuantidade());

		produto.setCategoria(CategoriaHttp.converterEntity(entidade.getCategoria()));

		// itens

		List<ItemPedidoHttp> listaAux = new ArrayList<ItemPedidoHttp>();
		for (ItemPedidoEntity item : entidade.getItens()) {

			ItemPedidoHttp aux = new ItemPedidoHttp();

			aux = ItemPedidoHttp.converterEntity(item);

			listaAux.add(aux);

		}

		produto.setItens(listaAux);

		produto.setIdUsuario(entidade.getIdUsuario());
		produto.setUltimaAtualizacao(entidade.getUltimaAtualizacao());

		return produto;

	}

	/**
	 * 
	 */
	public ProdutoHttp() {
		super();
	}

	/**
	 * @param ultimaAtualizacao
	 * @param idUsuario
	 */
	public ProdutoHttp(Date ultimaAtualizacao, int idUsuario) {
		super(ultimaAtualizacao, idUsuario);
	}

	/**
	 * @param ultimaAtualizacao
	 * @param idUsuario
	 * @param id
	 * @param nome
	 * @param descricao
	 * @param preco
	 * @param quantidade
	 * @param itens
	 * @param categoria
	 */
	public ProdutoHttp(Date ultimaAtualizacao, int idUsuario, int id, String nome, String descricao, double preco,
			int quantidade, List<ItemPedidoHttp> itens, CategoriaHttp categoria) {
		super(ultimaAtualizacao, idUsuario);
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.quantidade = quantidade;
		this.itens = itens;
		this.categoria = categoria;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
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
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao
	 *            the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the preco
	 */
	public double getPreco() {
		return preco;
	}

	/**
	 * @param preco
	 *            the preco to set
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}

	/**
	 * @return the quantidade
	 */
	public int getQuantidade() {
		return quantidade;
	}

	/**
	 * @param quantidade
	 *            the quantidade to set
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * @return the itens
	 */
	public List<ItemPedidoHttp> getItens() {
		return itens;
	}

	/**
	 * @param itens
	 *            the itens to set
	 */
	public void setItens(List<ItemPedidoHttp> itens) {
		this.itens = itens;
	}

	/**
	 * @return the categoria
	 */
	public CategoriaHttp getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria
	 *            the categoria to set
	 */
	public void setCategoria(CategoriaHttp categoria) {
		this.categoria = categoria;
	}

}
