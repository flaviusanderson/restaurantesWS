/**
 * 
 */
package br.com.informati.restaurantes.repositorio;

import java.util.List;

import br.com.informati.restaurantes.modelo.FormaPagamentoEntity;
import br.com.informati.restaurantes.modelo.PerfilEntity;

/**
 * @author Flavius
 *
 */
public class FormaPagamentoDAO extends GenericoDAO implements IGenericoDAO<FormaPagamentoEntity> {

	@Override
	public void salvar(FormaPagamentoEntity entidade) {
		
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(entidade);
		this.getEntityManager().getTransaction().commit();
		
	}

	@Override
	public void atualizar(FormaPagamentoEntity entidade) {
		
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().merge(entidade);
		this.getEntityManager().getTransaction().commit();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FormaPagamentoEntity> consultarTodos() {
		
		return this.getEntityManager().createQuery("SELECT p FROM FormaPagamentoEntity p ORDER BY p.nome").getResultList();
	}

	@Override
	public FormaPagamentoEntity consultarPorId(Integer id) {
		
		return this.getEntityManager().find(FormaPagamentoEntity.class, id);
		
	}

	@Override
	public void excluir(Integer id) {
		
		FormaPagamentoEntity entidade = this.consultarPorId(id);
		 
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().remove(entidade);
		this.getEntityManager().getTransaction().commit();
		
	}

}
