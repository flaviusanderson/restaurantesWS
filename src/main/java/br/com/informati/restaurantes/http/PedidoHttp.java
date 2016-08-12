/**
 * 
 */
package br.com.informati.restaurantes.http;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.informati.restaurantes.modelo.ItemPedidoEntity;
import br.com.informati.restaurantes.modelo.PagamentoEntity;
import br.com.informati.restaurantes.modelo.PedidoEntity;

/**
 * @author Flavius
 *
 */
public class PedidoHttp extends GenericoHttp {

	private int id;
	private String codigo;
	private String notaFiscal;
	private List<ItemPedidoHttp> itens;
	private ClienteHttp cliente;
	private List<PagamentoHttp> pagamentos;
	private MesaHttp mesa;
	
	public static PedidoHttp converterEntity(PedidoEntity entidade) {
		
		PedidoHttp pedido = new PedidoHttp();
		
		pedido.setId(entidade.getId());
		pedido.setCodigo(entidade.getCodigo());
		pedido.setNotaFiscal(entidade.getNotaFiscal());
		pedido.setMesa(MesaHttp.converterEntity(entidade.getMesa()));
		
		pedido.setIdUsuario(entidade.getIdUsuario());
		pedido.setUltimaAtualizacao(entidade.getUltimaAtualizacao());
		
		// itens
		
		List<ItemPedidoHttp> listaAux = new ArrayList<ItemPedidoHttp>();
		for(ItemPedidoEntity item : entidade.getItens()){
			
			ItemPedidoHttp aux = new ItemPedidoHttp();
			
			aux = ItemPedidoHttp.converterEntity(item);
			
			listaAux.add(aux);
			
		}
		
		pedido.setItens(listaAux);
		
		
		pedido.setCliente(ClienteHttp.converterEntity(entidade.getCliente()));
		
		// pagamentos
		
		List<PagamentoHttp> listaAuxPag = new ArrayList<PagamentoHttp>();
		for(PagamentoEntity item : entidade.getPagamentos()){
			
			PagamentoHttp aux = new PagamentoHttp();
			
			aux = PagamentoHttp.converterEntity(item);
			
			listaAuxPag.add(aux);
			
		}
		
		pedido.setPagamentos(listaAuxPag);
		
		return pedido;
	}
	
	/**
	 * 
	 */
	public PedidoHttp() {
		super();
	}
	/**
	 * @param ultimaAtualizacao
	 * @param idUsuario
	 */
	public PedidoHttp(Date ultimaAtualizacao, int idUsuario) {
		super(ultimaAtualizacao, idUsuario);
	}
	/**
	 * @param ultimaAtualizacao
	 * @param idUsuario
	 * @param id
	 * @param codigo
	 * @param notaFiscal
	 * @param itens
	 * @param cliente
	 * @param pagamentos
	 * @param mesa
	 */
	public PedidoHttp(Date ultimaAtualizacao, int idUsuario, int id, String codigo, String notaFiscal,
			List<ItemPedidoHttp> itens, ClienteHttp cliente, List<PagamentoHttp> pagamentos, MesaHttp mesa) {
		super(ultimaAtualizacao, idUsuario);
		this.id = id;
		this.codigo = codigo;
		this.notaFiscal = notaFiscal;
		this.itens = itens;
		this.cliente = cliente;
		this.pagamentos = pagamentos;
		this.mesa = mesa;
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
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the notaFiscal
	 */
	public String getNotaFiscal() {
		return notaFiscal;
	}
	/**
	 * @param notaFiscal the notaFiscal to set
	 */
	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
	/**
	 * @return the itens
	 */
	public List<ItemPedidoHttp> getItens() {
		return itens;
	}
	/**
	 * @param itens the itens to set
	 */
	public void setItens(List<ItemPedidoHttp> itens) {
		this.itens = itens;
	}
	/**
	 * @return the cliente
	 */
	public ClienteHttp getCliente() {
		return cliente;
	}
	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(ClienteHttp cliente) {
		this.cliente = cliente;
	}
	/**
	 * @return the pagamentos
	 */
	public List<PagamentoHttp> getPagamentos() {
		return pagamentos;
	}
	/**
	 * @param pagamentos the pagamentos to set
	 */
	public void setPagamentos(List<PagamentoHttp> pagamentos) {
		this.pagamentos = pagamentos;
	}
	/**
	 * @return the mesa
	 */
	public MesaHttp getMesa() {
		return mesa;
	}
	/**
	 * @param mesa the mesa to set
	 */
	public void setMesa(MesaHttp mesa) {
		this.mesa = mesa;
	}

	
}
