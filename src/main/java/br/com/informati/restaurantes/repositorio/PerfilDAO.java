/**
 * 
 */
package br.com.informati.restaurantes.repositorio;

import java.util.List;

import br.com.informati.restaurantes.modelo.PerfilEntity;

/**
 * @author Flavius
 *
 */
public class PerfilDAO extends GenericoDAO implements IGenericoDAO<PerfilEntity> {

	@Override
	public void salvar(PerfilEntity entidade) {

		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(entidade);
		this.getEntityManager().getTransaction().commit();
		
	}

	@Override
	public void atualizar(PerfilEntity entidade) {

		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().merge(entidade);
		this.getEntityManager().getTransaction().commit();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PerfilEntity> consultarTodos() {
		
		return this.getEntityManager().createQuery("SELECT p FROM PerfilEntity p ORDER BY p.nome").getResultList();
	}

	@Override
	public PerfilEntity consultarPorId(Integer id) {
		
		return this.getEntityManager().find(PerfilEntity.class, id);
		
	}

	@Override
	public void excluir(Integer id) {
	
		PerfilEntity entidade = this.consultarPorId(id);
		 
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().remove(entidade);
		this.getEntityManager().getTransaction().commit();
		
	}
	
}
