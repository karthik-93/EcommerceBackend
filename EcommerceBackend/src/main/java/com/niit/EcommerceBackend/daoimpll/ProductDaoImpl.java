package com.niit.EcommerceBackend.daoimpll;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.EcommerceBackend.dao.ProductDao;
import com.niit.EcommerceBackend.model.Product;

@Repository("productDao")
@Transactional

public class ProductDaoImpl implements ProductDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> listProducts() {
		return sessionFactory.getCurrentSession().createQuery("From Product").list();
	}

	public List<Product> listProducts(Product product) {
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("from Product");
		List list = query.list();

		return list;
	}

	@Override
	public Product getProductbyProductname(int productId) {
		Session session = sessionFactory.openSession();
		Product product = session.get(Product.class, productId);
		return product;
	}

	@Override
	public boolean deleteProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
