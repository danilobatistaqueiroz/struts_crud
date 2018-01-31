package com.keylesson.dao;

import java.util.List;

import org.hibernate.Session;

import com.keylesson.hibernate.HibernateUtil;
import com.keylesson.persistence.Category;

@SuppressWarnings("unchecked")
public class CategoryDAO {
	
	Session session;
	
	public CategoryDAO(Session session) {
		this.session = session;
	}

	public Category create(String name, String description) {
		Category category = new Category();
		try {
			session.beginTransaction();
			category.setName(name);
			category.setDescription(description);
			session.save(category);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error creating category :" + e.getMessage());
			e.printStackTrace(System.out);
			session.getTransaction().rollback();
		}
		return category;
	}

	public Category get(Integer id) {
		System.out.println("get category id:"+id);;
		Category category = null;
		try {
			session.beginTransaction();
			category = (Category)session.load(Category.class, id);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error getting category :" + e);
			session.getTransaction().rollback();
		}
		return category;
	}
	
	public Integer count() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Integer cnt = 0;
		try {
			session.beginTransaction();
			cnt = ( (Long) session.createQuery("select count(*) from Category").iterate().next() ).intValue();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error getting count of categories :" + e);
			session.getTransaction().rollback();
		}
		return cnt;
	}
	
	public List<Category> getAllCategories() {
		System.out.println("getAllCategories");
		List<Category> categories = null;
		try {
			session.beginTransaction();
			categories = session.createQuery("from Category").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error getting all categories :" + e);
			session.getTransaction().rollback();
		}
		return categories;
	}
	
	public List<Category> findByName(String name) {
		List<Category> categories = null;
		try {
			session.beginTransaction();
			categories = session
					.createQuery("from Category where name like :name")
					.setParameter("name", "%" + name + "%").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error getting categories :" + e);
			session.getTransaction().rollback();
		}
		return categories;
	}
	
	public List<Category> findByDescription(String description) {
		List<Category> categories = null;
		try {
			session.beginTransaction();
			categories = session
					.createQuery("from Category where description like :description")
					.setParameter("description", "%" + description + "%").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error getting categories :" + e);
			session.getTransaction().rollback();
		}
		return categories;
	}

	public String update(Integer id, String name, String description) {
		try {
			System.out.println("Category update id:"+id);
			session.beginTransaction();
			Category category = (Category)session.load(Category.class, id);
			category.setName(name);
			category.setDescription(description);
			session.saveOrUpdate(category);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error creating Category :" + e.getMessage());
			session.getTransaction().rollback();
			System.out.println("failure");
			return "failure" ;
		}
		System.out.println("success");
		return "success";
	}

	public String delete(Integer id) {
		try {
			System.out.println("category delete id:"+id);
			session.beginTransaction();
			Category category = (Category)session.get(Category.class,id);
		    session.delete(category);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error deleting category :" + e.getMessage());
			session.getTransaction().rollback();
			System.out.println("failure");
			return "failure" ;
		}
		System.out.println("success");
		return "success";
	}
}
