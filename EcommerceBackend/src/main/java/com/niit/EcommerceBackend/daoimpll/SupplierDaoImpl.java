package com.niit.EcommerceBackend.daoimpll;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.EcommerceBackend.dao.SupplierDao;
import com.niit.EcommerceBackend.model.Supplier;

@Repository("supplierDao")
@Transactional
public class SupplierDaoImpl implements SupplierDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public SupplierDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public boolean addSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(supplier);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean updateSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Supplier> listSuppliers() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Supplier");
		List listSuppliers = query.list();
		// session.close();
		return listSuppliers;
	}

	@Override
	public Supplier getSupplierbySupplierName(int supplierId) {
		Session session = sessionFactory.openSession();
		Supplier supplier = session.get(Supplier.class, supplierId);

		return supplier;
	}

	@Override
	public boolean deleteSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
