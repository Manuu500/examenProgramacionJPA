package controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Docente;


public class ControladorDocente {

	/**
	 * 
	 * @param descripcion
	 * @return
	 */
	public static List<Docente> findByLikeDescripcion(String descripcion){
		
		List<Docente> provincia = new ArrayList<Docente>();
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("examenJPA");

		EntityManager em = entityManagerFactory.createEntityManager();
		
		Query q = (Query) em.createNativeQuery("select * from docente where nombreCompleto like ?", Docente.class);
		
		q.setParameter(1, "%" + descripcion + "%");
		
		provincia.addAll(q.getResultList());
		
		em.close();
		return provincia;
	}	
	
}
