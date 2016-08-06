/**
 * 
 */
package br.com.informati.restaurantes.http;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import br.com.informati.restaurantes.modelo.ClienteEntity;
import br.com.informati.restaurantes.modelo.PedidoEntity;
import br.com.informati.restaurantes.modelo.ProdutoEntity;

/**
 * @author Flavius
 *
 */
public class ClienteHttp extends GenericoHttp {

	private int id;
	private String nome;
	private String cpf;
	private List<PedidoHttp> pedidos;
	
	public static ClienteHttp converterEntity(ClienteEntity entidade){
		
		ClienteHttp cliente = new ClienteHttp();
		
		cliente.setId(entidade.getId());
		cliente.setNome(entidade.getNome());
		cliente.setCpf(entidade.getCpf());
		cliente.setIdUsuario(entidade.getIdUsuario());
		cliente.setUltimaAtualizacao(entidade.getUltimaAtualizacao());
		
		List<PedidoHttp> listaAux = new ArrayList<PedidoHttp>();
		for(PedidoEntity pedido : entidade.getPedidos()){
			
			PedidoHttp aux = new PedidoHttp();
			
			aux = PedidoHttp.converterEntity(pedido);
			
			listaAux.add(aux);
			
		}
		
		cliente.setPedidos(listaAux);
		
		return cliente;
		
	}
	
	/**
	 * 
	 */
	public ClienteHttp() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param ultimaAtualizacao
	 * @param idUsuario
	 */
	public ClienteHttp(Date ultimaAtualizacao, int idUsuario) {
		super(ultimaAtualizacao, idUsuario);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param ultimaAtualizacao
	 * @param idUsuario
	 * @param id
	 * @param nome
	 * @param cpf
	 * @param pedidos
	 */
	public ClienteHttp(Date ultimaAtualizacao, int idUsuario, int id, String nome, String cpf,
			List<PedidoHttp> pedidos) {
		super(ultimaAtualizacao, idUsuario);
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.pedidos = pedidos;
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
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}
	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	/**
	 * @return the pedidos
	 */
	public List<PedidoHttp> getPedidos() {
		return pedidos;
	}
	/**
	 * @param pedidos the pedidos to set
	 */
	public void setPedidos(List<PedidoHttp> pedidos) {
		this.pedidos = pedidos;
	}
	
	
	
}
