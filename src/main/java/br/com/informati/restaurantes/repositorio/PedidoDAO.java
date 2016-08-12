/**
 * 
 */
package br.com.informati.restaurantes.repositorio;

import java.util.List;
import br.com.informati.restaurantes.modelo.PedidoEntity;

/**
 * @author Flavius
 *
 */
public class PedidoDAO extends GenericoDAO implements IGenericoDAO<PedidoEntity> {

	@Override
	public void salvar(PedidoEntity entidade) {

		
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(entidade);
		this.getEntityManager().getTransaction().commit();
		
	}

	@Override
	public void atualizar(PedidoEntity entidade) {
		
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().merge(entidade);
		this.getEntityManager().getTransaction().commit();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PedidoEntity> consultarTodos() {
		
		return this.getEntityManager().createQuery("SELECT p FROM PerfilEntity p ORDER BY p.nome").getResultList();
		
	}

	@Override
	public PedidoEntity consultarPorId(Integer id) {
		
		return this.getEntityManager().find(PedidoEntity.class, id);
		
	}

	@Override
	public void excluir(Integer id) {
		
		PedidoEntity entidade = this.consultarPorId(id);
		 
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().remove(entidade);
		this.getEntityManager().getTransaction().commit();
		
	}

}
