package com.niit.EcommerceBackend.dao;

import java.util.List;

import com.niit.EcommerceBackend.model.Product;

public interface ProductDao {
	public boolean addProduct(Product product);

	public boolean updateProduct(Product product);

	public List<Product> listProducts();

	public Product getProductbyProductname(int productId);

	public boolean deleteProduct(Product product);

}
