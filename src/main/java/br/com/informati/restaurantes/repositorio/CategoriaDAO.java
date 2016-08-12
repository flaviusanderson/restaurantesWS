/**
 * 
 */
package br.com.informati.restaurantes.repositorio;

import java.util.List;
import br.com.informati.restaurantes.modelo.CategoriaEntity;

/**
 * @author Flavius
 *
 */
public class CategoriaDAO extends GenericoDAO implements IGenericoDAO<CategoriaEntity> {

	@Override
	public void salvar(CategoriaEntity entidade) {
		
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(entidade);
		this.getEntityManager().getTransaction().commit();
		
	}

	@Override
	public void atualizar(CategoriaEntity entidade) {
		
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().merge(entidade);
		this.getEntityManager().getTransaction().commit();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CategoriaEntity> consultarTodos() {
		
		return this.getEntityManager().createQuery("SELECT c FROM CategoriaEntity c ORDER BY c.nome").getResultList();
		
	}

	@Override
	public CategoriaEntity consultarPorId(Integer id) {

		return this.getEntityManager().find(CategoriaEntity.class, id);

	}

	@Override
	public void excluir(Integer id) {

		CategoriaEntity entidade = this.consultarPorId(id);
		 
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().remove(entidade);
		this.getEntityManager().getTransaction().commit();
		
	}

}
