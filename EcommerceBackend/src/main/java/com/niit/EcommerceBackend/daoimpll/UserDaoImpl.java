package com.niit.EcommerceBackend.daoimpll;

import java.util.List;

import javax.transaction.Transaction;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.EcommerceBackend.dao.UserDao;
import com.niit.EcommerceBackend.model.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public boolean registerUser(User user) {
		try {
			user.setRole("ROLE_USER");
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	// @SuppressWarnings({ "deprecation", "rawtypes" })
	// public boolean updateAddress(String username) {
	// try {
	// Session session = sessionFactory.openSession();
	// Query query = session.createQuery("update User set password=:p where
	// username=:n");
	// query.setParameter("p", "pass12345");
	// query.setParameter("n", "vinod");
	// query.executeUpdate();
	// return true;
	// } catch (Exception e) {
	// return false;
	// }
	// }

	@Override
	public boolean updateUser(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<User> listUser() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("from User");
		@SuppressWarnings("rawtypes")
		List list = query.list();
		return list;
	}

	@Override
	public User getUserByUserName(int userId) {
		Session session = sessionFactory.openSession();
		User user = session.get(User.class, userId);

		return user;
	}

	@Override
	public boolean deleteUser(User user) {
		try {
			sessionFactory.getCurrentSession().delete(user);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
