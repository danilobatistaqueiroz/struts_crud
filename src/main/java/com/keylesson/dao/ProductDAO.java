package com.keylesson.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import com.keylesson.persistence.Category;
import com.keylesson.persistence.Product;

@SuppressWarnings("unchecked")
public class ProductDAO {
	
	Session session;
	
	public ProductDAO(Session session) {
		this.session = session;
	}

	public Product create(String name, Double price, Set<Category> categories) {
		Product product = new Product();
		try {
			session.beginTransaction();
			product.setName(name);
			product.setPrice(price);
			product.setCategories(categories);
			session.save(product);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error creating Product :" + e.getMessage());
			e.printStackTrace(System.out);
			session.getTransaction().rollback();
			//return "failure" ;
		}
		return product;
	}
	public Product save(Product product) {
		try {
			session.beginTransaction();
			session.save(product);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error creating Product :" + e.getMessage());
			e.printStackTrace(System.out);
			session.getTransaction().rollback();
		}
		return product;
	}

	public Product get(Integer id) {
		System.out.println("get product id:"+id);
		Product product = null;
		try {
			product = (Product)session.get(Product.class, id);
		} catch (Exception e) {
			System.err.println("Error getting Products :" + e);
			session.getTransaction().rollback();
		}
		return product;
	}
	
	public Integer count() {
		Integer cnt = 0;
		try {
			session.beginTransaction();
			cnt = ( (Long) session.createQuery("select count(*) from Product").iterate().next() ).intValue();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error getting Products :" + e);
			session.getTransaction().rollback();
		}
		return cnt;
	}
	
	public List<Product> getAllProducts() {
		System.out.println("getAllProducts");
		List<Product> products = null;
		try {
			products = session.createQuery("from Product").list();
		} catch (Exception e) {
			System.err.println("Error getting all Products :" + e);
			session.getTransaction().rollback();
		}
		return products;
	}
	
	public List<Product> findByName(String name) {
		List<Product> products = null;
		try {
			session.beginTransaction();
			products = session
					.createQuery("from Product where name like :name")
					.setParameter("name", "%" + name + "%").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error getting Products :" + e);
			session.getTransaction().rollback();
		}
		return products;
	}
	
	public List<Product> findByDescription(String description) {
		List<Product> products = null;
		try {
			session.beginTransaction();
			products = session
					.createQuery("from Product where description like :description")
					.setParameter("description", "%" + description + "%").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error getting Products :" + e);
			session.getTransaction().rollback();
		}
		return products;
	}

	public String update(Integer id, String name, Double price) {
		try {
			System.out.println("ProductDAO update");
			session.beginTransaction();
			Product product = (Product)session.load(Product.class, id);
			product.setName(name);
			product.setPrice(price);
			session.saveOrUpdate(product);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error creating Product :" + e.getMessage());
			session.getTransaction().rollback();
			System.out.println("failure");
			return "failure" ;
		}
		System.out.println("success");
		return "success";
	}

	public String delete(Integer id) {
		try {
			System.out.println("ProductDAO delete id:"+id);
			session.beginTransaction();
			Product product = (Product)session.get(Product.class,id);
		    session.delete(product);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error deleting Product :" + e.getMessage());
			e.printStackTrace(System.err);
			session.getTransaction().rollback();
			System.out.println("failure");
			return "failure" ;
		}
		System.out.println("success");
		return "success";
	}
}
