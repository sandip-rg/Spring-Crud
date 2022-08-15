package com.springcrud.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.springcrud.model.Product;

@Component
public class ProductDao {
	@Autowired
	private HibernateTemplate hibernateTemplae;
	
	
	//Create and update
	@Transactional
	public void createProduct(Product product) {
		this.hibernateTemplae.saveOrUpdate(product);
	}
	
	//Get all product
	public List<Product> getAllProducts(){
		List<Product> products = this.hibernateTemplae.loadAll(Product.class);
		return products;
	}
	
	//Get Single product
	public Product getProduct(int id) {
		return this.hibernateTemplae.get(Product.class, id);
	}
	
	//Delete single product
	@Transactional
	public void deleteProduct(int id) {
		Product product = this.hibernateTemplae.load(Product.class, id);
		this.hibernateTemplae.delete(product);
	}
}
