/**
 * 
 */
package br.com.informati.restaurantes.repositorio;

import java.util.List;
import br.com.informati.restaurantes.modelo.PagamentoEntity;

/**
 * @author Flavius
 *
 */
public class PagamentoDAO extends GenericoDAO implements IGenericoDAO<PagamentoEntity> {

	@Override
	public void salvar(PagamentoEntity entidade) {

		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(entidade);
		this.getEntityManager().getTransaction().commit();
		
	}

	@Override
	public void atualizar(PagamentoEntity entidade) {
		
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().merge(entidade);
		this.getEntityManager().getTransaction().commit();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PagamentoEntity> consultarTodos() {

		return this.getEntityManager().createQuery("SELECT p FROM PagamentoEntity p ORDER BY p.nome").getResultList();
		
	}

	@Override
	public PagamentoEntity consultarPorId(Integer id) {
		
		return this.getEntityManager().find(PagamentoEntity.class, id);
		
	}

	@Override
	public void excluir(Integer id) {
		
		PagamentoEntity entidade = this.consultarPorId(id);
		 
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().remove(entidade);
		this.getEntityManager().getTransaction().commit();
		
	}

}
