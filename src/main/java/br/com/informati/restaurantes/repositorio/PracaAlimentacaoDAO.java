/**
 * 
 */
package br.com.informati.restaurantes.repositorio;

import java.util.List;
import br.com.informati.restaurantes.modelo.PracaAlimentacaoEntity;

/**
 * @author Flavius
 *
 */
public class PracaAlimentacaoDAO extends GenericoDAO implements IGenericoDAO<PracaAlimentacaoEntity> {

	@Override
	public void salvar(PracaAlimentacaoEntity entidade) {
		
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(entidade);
		this.getEntityManager().getTransaction().commit();
		
	}

	@Override
	public void atualizar(PracaAlimentacaoEntity entidade) {
		
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().merge(entidade);
		this.getEntityManager().getTransaction().commit();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PracaAlimentacaoEntity> consultarTodos() {
		
		return this.getEntityManager().createQuery("SELECT c FROM PracaAlimentacaoEntity c ORDER BY c.nome").getResultList();
	}

	@Override
	public PracaAlimentacaoEntity consultarPorId(Integer id) {
		return this.getEntityManager().find(PracaAlimentacaoEntity.class, id);
	}

	@Override
	public void excluir(Integer id) {
		
		PracaAlimentacaoEntity entidade = this.consultarPorId(id);
		 
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().remove(entidade);
		this.getEntityManager().getTransaction().commit();
		
	}

}
