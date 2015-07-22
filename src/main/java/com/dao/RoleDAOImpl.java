package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Person;
import com.model.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {

	/*
	 * @Autowired private SessionFactory sessionFactory;
	 * 
	 * private Session getCurrentSession() { return
	 * sessionFactory.getCurrentSession(); }
	 * 
	 * public Role getRole(int id) { Role role = (Role)
	 * getCurrentSession().load(Role.class, id); return role; }
	 */

	@PersistenceContext
	private EntityManager entityManager;

	public Role getById(Integer id) {
		try {
			return (Role) entityManager
					.createQuery("select r from Role r where r.id=?")
					.setParameter(1, id).getSingleResult();
		} catch (NoResultException noResultException) {
			return null;
		}
	}

	public Role getRole(int id) {
		try {
			return (Role) entityManager
					.createQuery("select r from Role r where r.id=?")
					.setParameter(1, id).getSingleResult();
		} catch (NoResultException noResultException) {
			return null;
		}
	}

}
