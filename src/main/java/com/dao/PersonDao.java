package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
 





import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.model.Person;
 
@Repository("personDao")
@Transactional(propagation = Propagation.REQUIRED)
public class PersonDao {
 
private static final String SELECT_QUERY = "select p from Person p";
 
@PersistenceContext
private EntityManager entityManager;


public EntityManager getEntityManager() {
return entityManager;
}
 
public void setEntityManager(EntityManager entityManager) {
this.entityManager = entityManager;
}
 
@Transactional
public void insert(Person person) {
	/*EntityTransaction tx = null;
    tx = entityManager.getTransaction();
    tx.begin();*/
    entityManager.persist(person);
    //tx.commit();
	System.out.println("Add person");
	
//entityManager.persist(person);
}

@PreAuthorize("hasRole('ROLE_ADMIN')")
public void delete(Long personID){
//	EntityTransaction tx = entityManager.getTransaction();
	//tx.begin();
    Person person = entityManager.find(Person.class, personID);
    entityManager.remove(person);
    //tx.commit();
    
    /*EntityManager em = emf.createEntityManager();
	em.getTransaction().begin();
	// ID пользователя для поиска 1 исключить
	Person person = em.find(Person.class, 2L);
	em.remove(person);
	em.getTransaction().commit();
	em.close();*/
    
}
 
public List<Person> selectAll() {
Query query = entityManager.createQuery(SELECT_QUERY);
List<Person> persons = (List<Person>) query.getResultList();
return persons;
}

	public Person getById(Integer id) {
		try {
			return (Person) entityManager
					.createQuery("select p from Person p where p.id=?")
					.setParameter(1, id).getSingleResult();
		} catch (NoResultException noResultException) {
			return null;
		}
	}
 
}

