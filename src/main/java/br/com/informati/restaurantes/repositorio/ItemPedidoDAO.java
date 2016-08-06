/**
 * 
 */
package br.com.informati.restaurantes.repositorio;

import java.util.List;

import br.com.informati.restaurantes.modelo.ItemPedidoEntity;
import br.com.informati.restaurantes.modelo.PerfilEntity;

/**
 * @author Flavius
 *
 */
public class ItemPedidoDAO extends GenericoDAO implements IGenericoDAO<ItemPedidoEntity> {

	@Override
	public void salvar(ItemPedidoEntity entidade) {
		
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(entidade);
		this.getEntityManager().getTransaction().commit();
		
	}

	@Override
	public void atualizar(ItemPedidoEntity entidade) {
		
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().merge(entidade);
		this.getEntityManager().getTransaction().commit();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemPedidoEntity> consultarTodos() {
		
		return this.getEntityManager().createQuery("SELECT p FROM ItemPedidoEntity p ORDER BY p.nome").getResultList();
		
	}

	@Override
	public ItemPedidoEntity consultarPorId(Integer id) {
		
		return this.getEntityManager().find(ItemPedidoEntity.class, id);
		
	}

	@Override
	public void excluir(Integer id) {
		
		ItemPedidoEntity entidade = this.consultarPorId(id);
		 
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().remove(entidade);
		this.getEntityManager().getTransaction().commit();
		
	}

}
