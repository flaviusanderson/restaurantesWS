/**
 * 
 */
package br.com.informati.restaurantes.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Flavius
 *
 */
@Entity
@Table(name = "tb_pedido")
public class PedidoEntity extends GenericoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "notaFiscal")
	private String notaFiscal;
	
	@OneToMany(mappedBy = "pedido", targetEntity = PagamentoEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PagamentoEntity> pagamentos;
	
	@ManyToOne
	@JoinColumn(name="idCliente")
	private ClienteEntity cliente;
	
	@OneToMany(mappedBy = "pedido", targetEntity = ItemPedidoEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ItemPedidoEntity> itens;
	
	@OneToOne
	@JoinColumn(name="idMesa")
	private MesaEntity mesa;

	/**
	 * 
	 */
	public PedidoEntity() {
		super();
	}

	/**
	 * @param id
	 * @param codigo
	 * @param notaFiscal
	 * @param pagamentos
	 * @param cliente
	 * @param itens
	 * @param mesa
	 */
	public PedidoEntity(Integer id, String codigo, String notaFiscal, List<PagamentoEntity> pagamentos,
			ClienteEntity cliente, List<ItemPedidoEntity> itens, MesaEntity mesa) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.notaFiscal = notaFiscal;
		this.pagamentos = pagamentos;
		this.cliente = cliente;
		this.itens = itens;
		this.mesa = mesa;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
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
	 * @return the pagamentos
	 */
	public List<PagamentoEntity> getPagamentos() {
		return pagamentos;
	}

	/**
	 * @param pagamentos the pagamentos to set
	 */
	public void setPagamentos(List<PagamentoEntity> pagamentos) {
		this.pagamentos = pagamentos;
	}

	/**
	 * @return the cliente
	 */
	public ClienteEntity getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the itens
	 */
	public List<ItemPedidoEntity> getItens() {
		return itens;
	}

	/**
	 * @param itens the itens to set
	 */
	public void setItens(List<ItemPedidoEntity> itens) {
		this.itens = itens;
	}

	/**
	 * @return the mesa
	 */
	public MesaEntity getMesa() {
		return mesa;
	}

	/**
	 * @param mesa the mesa to set
	 */
	public void setMesa(MesaEntity mesa) {
		this.mesa = mesa;
	}
	
}
