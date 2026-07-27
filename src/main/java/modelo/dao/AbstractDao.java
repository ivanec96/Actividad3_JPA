package modelo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public abstract class AbstractDao {

	protected EntityManagerFactory emf;
	protected EntityManager em;
	protected EntityTransaction tx;
	protected Query query;
	protected String jpql; // Pseudo sql que utiliza las clases y sus atributos para hacer consultas
	protected int filas;
	
	
	public AbstractDao() {
		emf = Persistence.createEntityManagerFactory("C02_JPA_MySQL_HR");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}
	
	
}
