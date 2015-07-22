package com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Role;
import com.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	/*
	 * @Autowired private SessionFactory sessionFactory;
	 * 
	 * private org.hibernate.Session openSession() { return
	 * sessionFactory.getCurrentSession(); }
	 * 
	 * public User getUser(String login) { List<User> userList = new
	 * ArrayList<User>(); try { Query query = openSession().createQuery(
	 * "from User u where u.login = :login"); query.setParameter("login",
	 * login); userList = query.list(); } catch (Exception e) {
	 * System.out.println(":(:(:(:("); } if (userList.size() > 0) return
	 * userList.get(0); else return null; }
	 */

	@PersistenceContext
	private EntityManager entityManager;

	public User getUser(String login) {
		try {
			return (User) entityManager
					.createQuery("select u from User u where u.login=?")
					.setParameter(1, login).getSingleResult();
		} catch (NoResultException noResultException) {
			return null;
		}
	}

}