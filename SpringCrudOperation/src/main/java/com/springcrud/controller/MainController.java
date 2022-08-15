package com.springcrud.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.springcrud.dao.ProductDao;
import com.springcrud.model.Product;

@Controller
public class MainController {
	@Autowired
	private ProductDao productDao;

	@RequestMapping("/")
	public String home(Model m) {
		List<Product> allProducts = productDao.getAllProducts();
		m.addAttribute("Product", allProducts);
		return "index";
	}
	//add product
	@RequestMapping("/add-product")
	public String addProduct(Model m) {
		m.addAttribute("title", "Add Product");
		return "add_product_form";
	}
	
	//handle add product
	@RequestMapping(value="/handle-product", method= RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product, HttpServletRequest request) {
		System.out.println(product);
		productDao.createProduct(product);
		RedirectView view = new RedirectView();
		view.setUrl(request.getContextPath() + "/");
		return view;
	}
	
	//update handler
	@RequestMapping("/update/{productId}")
	public String updateProduct(@PathVariable("productId") int productId, Model m) {
		Product product = this.productDao.getProduct(productId);
		m.addAttribute("product", product);
		return "update_form";
	}
	
	//delete handler
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int productId, HttpServletRequest request) {
		System.out.println(productId);
		this.productDao.deleteProduct(productId);
		RedirectView view = new RedirectView();
		view.setUrl(request.getContextPath() + "/");
		return view;
	}
}
