/**
 * 
 */
package br.com.informati.restaurantes.controller;

import java.util.List;

/**
 * @author Flavius
 *
 */
public interface IGenericoController<T> {
	
	String cadastrar(T entidade);
	
	String atualizar(T entidade);
	
	List<T> consultarTodos();
	
	T consultarPorId(int id);
	
	String excluir(int id);
	

}
