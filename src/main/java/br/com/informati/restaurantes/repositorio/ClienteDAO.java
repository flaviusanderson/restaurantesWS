/**
 * 
 */
package br.com.informati.restaurantes.repositorio;

import java.util.List;
import br.com.informati.restaurantes.modelo.ClienteEntity;

/**
 * @author Flavius
 *
 */
public class ClienteDAO extends GenericoDAO implements IGenericoDAO<ClienteEntity> {

	@Override
	public void salvar(ClienteEntity entidade) {

		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(entidade);
		this.getEntityManager().getTransaction().commit();
		
	}

	@Override
	public void atualizar(ClienteEntity entidade) {
		
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().merge(entidade);
		this.getEntityManager().getTransaction().commit();
		
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<ClienteEntity> consultarTodos() {

		return this.getEntityManager().createQuery("SELECT c FROM ClienteEntity c ORDER BY c.nome").getResultList();
		
	}

	@Override
	public ClienteEntity consultarPorId(Integer id) {

		return this.getEntityManager().find(ClienteEntity.class, id);
		
	}

	@Override
	public void excluir(Integer id) {
		
		ClienteEntity entidade = this.consultarPorId(id);
		 
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().remove(entidade);
		this.getEntityManager().getTransaction().commit();
		
	}

	
}
