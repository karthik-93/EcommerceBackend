package com.niit.Test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.EcommerceBackend.dao.SupplierDao;
import com.niit.EcommerceBackend.model.Supplier;

public class SupplierUnitTest {
	static SupplierDao supplierDao;

	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		supplierDao = (SupplierDao) context.getBean("supplierDao");

	}

	@Ignore
	@Test
	public void test() {
		Supplier supplier = new Supplier();
		// supplier.setSupplierId(000001);
		// supplier.setSupplierName("Electronics Supply");
		// supplier.setSupplierAddr("Mumbai");
		//

		// supplier.setSupplierId(000002);
		// supplier.setSupplierName("Electronics Supply");
		// supplier.setSupplierAddr("Mumbai");
		//
		supplier.setSupplierId(000005);
		supplier.setSupplierName("Normal Supply");
		supplier.setSupplierAddr("bangalore");

		assertTrue("Problem in add Supplier:", supplierDao.addSupplier(supplier));

	}

	@Ignore
	@Test
	public void listSupplier() {
		Supplier supplier = new Supplier();
		List<Supplier> li = supplierDao.listSuppliers();
		System.out.println(li.size());
		for (Supplier s : li) {
			System.out.println(s.getSupplierAddr() + s.getSupplierId() + s.getSupplierName());
		}
	}

//	@Ignore
//	@Test
//	public void deleteSupplier() {
//		Supplier supplier = new Supplier();
//		assertTrue("Problem in deleting data:", supplierDao.deleteSupplier(2));
//	}
	
	@Test
	public void updateSupplier() {
		Supplier supplier = supplierDao.getSupplierbySupplierName(75);
		supplier.setSupplierAddr("Hyderabad");
		supplierDao.updateSupplier(supplier);
		assertEquals("Problem in updating details", "Normal Supply", supplier.getSupplierName());
	}
	@Ignore
	@Test
	public void deleteSupplier() {
		Supplier supplier = supplierDao.getSupplierbySupplierName(3);
		supplierDao.deleteSupplier(supplier);
		assertEquals("Problem in deleting supplier",true,true);
	}

}
