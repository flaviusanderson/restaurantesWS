/**
 * 
 */
package br.com.informati.restaurantes.repositorio;

import java.util.List;
import br.com.informati.restaurantes.modelo.ProdutoEntity;

/**
 * @author Flavius
 *
 */
public class ProdutoDAO extends GenericoDAO implements IGenericoDAO<ProdutoEntity> {

	@Override
	public void salvar(ProdutoEntity entidade) {

		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(entidade);
		this.getEntityManager().getTransaction().commit();

	}

	@Override
	public void atualizar(ProdutoEntity entidade) {

		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().merge(entidade);
		this.getEntityManager().getTransaction().commit();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProdutoEntity> consultarTodos() {
		return this.getEntityManager().createQuery("SELECT p FROM ProdutoEntity p ORDER BY p.nome").getResultList();
	}

	@Override
	public ProdutoEntity consultarPorId(Integer id) {

		return this.getEntityManager().find(ProdutoEntity.class, id);
		
	}

	@Override
	public void excluir(Integer id) {
		
		ProdutoEntity entidade = this.consultarPorId(id);
		 
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().remove(entidade);
		this.getEntityManager().getTransaction().commit();

	}

}
