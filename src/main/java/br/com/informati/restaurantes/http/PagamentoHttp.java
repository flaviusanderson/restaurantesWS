/**
 * 
 */
package br.com.informati.restaurantes.http;

import java.util.Date;

import br.com.informati.restaurantes.modelo.PagamentoEntity;

/**
 * @author Flavius
 *
 */
public class PagamentoHttp extends GenericoHttp {

	private int id;
	private double valor;
	private PedidoHttp pedido;
	private FormaPagamentoHttp formaPagamento;

	public static PagamentoHttp converterEntity(PagamentoEntity entidade) {
		PagamentoHttp pagamento = new PagamentoHttp();

		pagamento.setId(entidade.getId());
		pagamento.setValor(entidade.getValor());
		pagamento.setPedido(PedidoHttp.converterEntity(entidade.getPedido()));
		pagamento.setFormaPagamento(FormaPagamentoHttp.converterEntity(entidade.getFormaPagamento()));
		pagamento.setIdUsuario(entidade.getIdUsuario());
		pagamento.setUltimaAtualizacao(entidade.getUltimaAtualizacao());

		return pagamento;
	}

	/**
	 * 
	 */
	public PagamentoHttp() {
		super();
	}

	/**
	 * @param ultimaAtualizacao
	 * @param idUsuario
	 */
	public PagamentoHttp(Date ultimaAtualizacao, int idUsuario) {
		super(ultimaAtualizacao, idUsuario);
	}

	/**
	 * @param ultimaAtualizacao
	 * @param idUsuario
	 * @param id
	 * @param valor
	 * @param pedido
	 * @param formaPagamento
	 */
	public PagamentoHttp(Date ultimaAtualizacao, int idUsuario, int id, double valor, PedidoHttp pedido,
			FormaPagamentoHttp formaPagamento) {
		super(ultimaAtualizacao, idUsuario);
		this.id = id;
		this.valor = valor;
		this.pedido = pedido;
		this.formaPagamento = formaPagamento;
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
	 * @return the valor
	 */
	public double getValor() {
		return valor;
	}

	/**
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}

	/**
	 * @return the pedido
	 */
	public PedidoHttp getPedido() {
		return pedido;
	}

	/**
	 * @param pedido
	 *            the pedido to set
	 */
	public void setPedido(PedidoHttp pedido) {
		this.pedido = pedido;
	}

	/**
	 * @return the formaPagamento
	 */
	public FormaPagamentoHttp getFormaPagamento() {
		return formaPagamento;
	}

	/**
	 * @param formaPagamento
	 *            the formaPagamento to set
	 */
	public void setFormaPagamento(FormaPagamentoHttp formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

}
