/**
 * 
 */
package br.com.informati.restaurantes.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Flavius
 *
 */
public abstract class GenericoDAO {

	private EntityManager entityManager;
	private EntityManagerFactory entityManagerFactory;
	 
	/**
	 * @return the entityManagerFactory
	 */
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	/**
	 * @param entityManagerFactory the entityManagerFactory to set
	 */
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	/**
	 * @return the entityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * @param entityManager the entityManager to set
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

 
	
	public GenericoDAO(){
 
		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("pu_db_restaurantes");
 
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
}
