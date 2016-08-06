/**
 * 
 */
package br.com.informati.restaurantes.http;

import java.util.Date;

import br.com.informati.restaurantes.modelo.ItemPedidoEntity;

/**
 * @author Flavius
 *
 */
public class ItemPedidoHttp extends GenericoHttp {

	private int id;
	private String nome;
	private double precoUnitario;
	private int quantidade;
	private PedidoHttp pedido;
	private ProdutoHttp produto;
	
	public static ItemPedidoHttp converterEntity(ItemPedidoEntity entidade){
		
		ItemPedidoHttp item = new ItemPedidoHttp();
		
		item.setId(entidade.getId());
		item.setNome(entidade.getNome());
		item.setPrecoUnitario(entidade.getPrecoUnitario());
		item.setQuantidade(entidade.getQuantidade());
		item.setPedido(PedidoHttp.converterEntity(entidade.getPedido()));
		item.setProduto(ProdutoHttp.converterEntity(entidade.getProduto()));
		item.setIdUsuario(entidade.getIdUsuario());
		item.setUltimaAtualizacao(entidade.getUltimaAtualizacao());
		
		return item;
		
	}
	/**
	 * 
	 */
	public ItemPedidoHttp() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param ultimaAtualizacao
	 * @param idUsuario
	 */
	public ItemPedidoHttp(Date ultimaAtualizacao, int idUsuario) {
		super(ultimaAtualizacao, idUsuario);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param ultimaAtualizacao
	 * @param idUsuario
	 * @param id
	 * @param nome
	 * @param precoUnitario
	 * @param quantidade
	 * @param pedido
	 * @param produto
	 */
	public ItemPedidoHttp(Date ultimaAtualizacao, int idUsuario, int id, String nome, double precoUnitario,
			int quantidade, PedidoHttp pedido, ProdutoHttp produto) {
		super(ultimaAtualizacao, idUsuario);
		this.id = id;
		this.nome = nome;
		this.precoUnitario = precoUnitario;
		this.quantidade = quantidade;
		this.pedido = pedido;
		this.produto = produto;
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
	 * @return the precoUnitario
	 */
	public double getPrecoUnitario() {
		return precoUnitario;
	}
	/**
	 * @param precoUnitario the precoUnitario to set
	 */
	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	/**
	 * @return the quantidade
	 */
	public int getQuantidade() {
		return quantidade;
	}
	/**
	 * @param quantidade the quantidade to set
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	/**
	 * @return the pedido
	 */
	public PedidoHttp getPedido() {
		return pedido;
	}
	/**
	 * @param pedido the pedido to set
	 */
	public void setPedido(PedidoHttp pedido) {
		this.pedido = pedido;
	}
	/**
	 * @return the produto
	 */
	public ProdutoHttp getProduto() {
		return produto;
	}
	/**
	 * @param produto the produto to set
	 */
	public void setProduto(ProdutoHttp produto) {
		this.produto = produto;
	}
	
	
}
