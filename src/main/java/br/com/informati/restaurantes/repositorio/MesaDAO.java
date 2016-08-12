/**
 * 
 */
package br.com.informati.restaurantes.repositorio;

import java.util.List;
import br.com.informati.restaurantes.modelo.MesaEntity;

/**
 * @author Flavius
 *
 */
public class MesaDAO extends GenericoDAO implements IGenericoDAO<MesaEntity> {

	@Override
	public void salvar(MesaEntity entidade) {
		
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(entidade);
		this.getEntityManager().getTransaction().commit();
		
	}

	@Override
	public void atualizar(MesaEntity entidade) {
		
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().merge(entidade);
		this.getEntityManager().getTransaction().commit();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MesaEntity> consultarTodos() {
		
		return this.getEntityManager().createQuery("SELECT m FROM MesaEntity m ORDER BY m.codigo").getResultList();
		
	}

	@Override
	public MesaEntity consultarPorId(Integer id) {
		
		return this.getEntityManager().find(MesaEntity.class, id);
		
	}

	@Override
	public void excluir(Integer id) {
		
		MesaEntity entidade = this.consultarPorId(id);
		 
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().remove(entidade);
		this.getEntityManager().getTransaction().commit();
		
	}

}
