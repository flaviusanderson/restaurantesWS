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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Flavius
 *
 */
@Entity
@Table(name="tb_cliente")
public class ClienteEntity extends GenericoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cpf")
	private String cpf;
	
	@OneToMany(mappedBy = "cliente", targetEntity = PedidoEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PedidoEntity> pedidos;

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
	public List<PedidoEntity> getPedidos() {
		return pedidos;
	}

	/**
	 * @param pedidos the pedidos to set
	 */
	public void setPedidos(List<PedidoEntity> pedidos) {
		this.pedidos = pedidos;
	}

	/**
	 * @param id
	 * @param nome
	 * @param cpf
	 * @param pedidos
	 */
	public ClienteEntity(Integer id, String nome, String cpf, List<PedidoEntity> pedidos) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.pedidos = pedidos;
	}
	
	public ClienteEntity(){}
}
