/**
 * 
 */
package br.com.informati.restaurantes.repositorio;

import java.util.List;

import br.com.informati.restaurantes.modelo.RestauranteEntity;
import br.com.informati.restaurantes.modelo.UsuarioEntity;

/**
 * @author Flavius
 *
 */
public class RestauranteDAO extends GenericoDAO implements IGenericoDAO<RestauranteEntity> {

	@Override
	public void salvar(RestauranteEntity entidade) {
		
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(entidade);
		this.getEntityManager().getTransaction().commit();
		
	}

	@Override
	public void atualizar(RestauranteEntity entidade) {
		
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().merge(entidade);
		this.getEntityManager().getTransaction().commit();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RestauranteEntity> consultarTodos() {
		
		return this.getEntityManager().createQuery("SELECT r FROM RestauranteEntity r ORDER BY r.nome").getResultList();
		
	}

	@Override
	public RestauranteEntity consultarPorId(Integer id) {

		return this.getEntityManager().find(RestauranteEntity.class, id);
		
	}

	@Override
	public void excluir(Integer id) {
		
		RestauranteEntity entidade = this.consultarPorId(id);
		 
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().remove(entidade);
		this.getEntityManager().getTransaction().commit();
		
	}

}
