/**
 * 
 */
package br.com.informati.restaurantes.repositorio;

import java.util.List;

/**
 * @author Flavius
 *
 */
public interface IGenericoDAO<T> {

	void salvar(T entidade);
	
	void atualizar(T entidade);
	
	List<T> consultarTodos();
	
	T consultarPorId(Integer id);
	
	void excluir(Integer id);
	
	
}
