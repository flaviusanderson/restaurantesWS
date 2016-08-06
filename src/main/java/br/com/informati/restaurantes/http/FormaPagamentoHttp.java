/**
 * 
 */
package br.com.informati.restaurantes.http;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.informati.restaurantes.modelo.FormaPagamentoEntity;
import br.com.informati.restaurantes.modelo.ItemPedidoEntity;
import br.com.informati.restaurantes.modelo.PagamentoEntity;

/**
 * @author Flavius
 *
 */
public class FormaPagamentoHttp extends GenericoHttp {

	private int id;
	private String nome;
	private List<PagamentoHttp> pagamentos;
	
	public static FormaPagamentoHttp converterEntity(FormaPagamentoEntity entidade)
	{
		FormaPagamentoHttp forma = new FormaPagamentoHttp();
		
		forma.setId(entidade.getId());
		forma.setNome(entidade.getNome());
		forma.setIdUsuario(entidade.getIdUsuario());
		forma.setUltimaAtualizacao(entidade.getUltimaAtualizacao());
		
		List<PagamentoHttp> listaAux = new ArrayList<PagamentoHttp>();
		for(PagamentoEntity item : entidade.getPagamentos()){
			
			PagamentoHttp aux = new PagamentoHttp();
			
			aux = PagamentoHttp.converterEntity(item);
			
			listaAux.add(aux);
			
		}
		
		forma.setPagamentos(listaAux);
		
		
		
		return forma;
	}
	
	/**
	 * 
	 */
	public FormaPagamentoHttp() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param ultimaAtualizacao
	 * @param idUsuario
	 */
	public FormaPagamentoHttp(Date ultimaAtualizacao, int idUsuario) {
		super(ultimaAtualizacao, idUsuario);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param ultimaAtualizacao
	 * @param idUsuario
	 * @param id
	 * @param nome
	 * @param pagamentos
	 */
	public FormaPagamentoHttp(Date ultimaAtualizacao, int idUsuario, int id, String nome,
			List<PagamentoHttp> pagamentos) {
		super(ultimaAtualizacao, idUsuario);
		this.id = id;
		this.nome = nome;
		this.pagamentos = pagamentos;
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
	
	
	
}
