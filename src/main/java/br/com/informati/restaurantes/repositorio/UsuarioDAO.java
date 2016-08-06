/**
 * 
 */
package br.com.informati.restaurantes.repositorio;

import java.util.List;
import br.com.informati.restaurantes.modelo.UsuarioEntity;

/**
 * @author Flavius
 *
 */
public class UsuarioDAO extends GenericoDAO implements IGenericoDAO<UsuarioEntity> {

	@Override
	public void salvar(UsuarioEntity entidade) {
		
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(entidade);
		this.getEntityManager().getTransaction().commit();
	}

	@Override
	public void atualizar(UsuarioEntity entidade) {
		
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().merge(entidade);
		this.getEntityManager().getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UsuarioEntity> consultarTodos() {
		
		return this.getEntityManager().createQuery("SELECT u FROM UsuarioEntity u ORDER BY u.nome").getResultList();
	}

	@Override
	public UsuarioEntity consultarPorId(Integer id) {
		
		return this.getEntityManager().find(UsuarioEntity.class, id);
	}

	@Override
	public void excluir(Integer id) {

		UsuarioEntity entidade = this.consultarPorId(id);
		 
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().remove(entidade);
		this.getEntityManager().getTransaction().commit();
		
	}

	
}
