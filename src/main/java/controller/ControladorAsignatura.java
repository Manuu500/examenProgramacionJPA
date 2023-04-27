package controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Asignatura;
import model.Asignaturaspordocente;


public class ControladorAsignatura {


	/**
	 * 
	 * @param object 
	 * @return
	 */
	public static List<Asignatura> findAll(){
		
		List<Asignatura> lista = new ArrayList<Asignatura>();
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("examenJPA");

		EntityManager em = entityManagerFactory.createEntityManager();
		
		Query q = (Query) em.createNativeQuery("select * from asignatura", Asignatura.class);
		
		lista.addAll(q.getResultList());
		
		em.close();
		return lista;
	}

	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public static List<Asignatura> findById(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("examenJPA");
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("select * from asignaturaspordocente ad, asignatura a where ad.idAsignatura = a.id and ad.idDocente = ?;", Asignatura.class);
		q.setParameter(1, id);
		
		List<Asignatura> p = (List<Asignatura>) q.getResultList();
		em.close();
		return p;
	}
}
