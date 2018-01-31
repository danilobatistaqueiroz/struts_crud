package com.keylesson.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.keylesson.persistence.User;

@SuppressWarnings("unchecked")
public class UserDAO {
	
	Session session; 
			
	public UserDAO(Session session) {
		this.session = session;		
	}

	public String create(String login, String name, Integer age, String phone, String email, String password) {
		try {
			session.beginTransaction();
			User user = new User();
			user.setLogin(login);
			user.setName(name);
			user.setAge(age);
			user.setPhone(phone);
			user.setEmail(email);
			user.setPassword(password);
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error creating User :" + e.getMessage());
			e.printStackTrace(System.out);
			session.getTransaction().rollback();
			return "failure" ;
		}
		return "success";
	}
	public void save(User user) {
		try {
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error creating User :" + e.getMessage());
			e.printStackTrace(System.out);
			session.getTransaction().rollback();
		}		
	}

	public User get(Integer id) {
		User user = null;
		try {
			session.beginTransaction();
			user = (User)session
					.createQuery("from User where id = :id")
					.setParameter("id", id)
					.uniqueResult();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error getting Users :" + e);
			session.getTransaction().rollback();
		}
		return user;
	}
	
	public List<User> find(String name) {
		List<User> users = null;
		try {
			session.beginTransaction();
			users = session
					.createQuery("from User where name like :name")
					.setParameter("name", "%" + name + "%").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error getting Users :" + e);
			session.getTransaction().rollback();
		}
		return users;
	}

	public String update(String name, Integer age) {
		List<User> users = null;
		try {
			System.out.println("update");
			session.beginTransaction();
			users = session
					.createQuery("from User where name like :name")
					.setParameter("name", "%" + name + "%").list();
			User user = new User();
			((User)users.get(0)).setName(name);
			((User)users.get(0)).setAge(age);
			user = ((User)users.get(0));
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error creating User :" + e.getMessage());
			session.getTransaction().rollback();
			System.out.println("failure");
			return "failure" ;
		}
		System.out.println("success");
		return "success";
	}

	public String delete(String name, Integer age) {
		try {
			System.out.println("delete");
			session.beginTransaction();
			Query q = session
					.createQuery("delete User where name like :name and age = :age")
					.setParameter("name", "%" + name + "%")
					.setParameter("age", age);
			q.executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error deleting User :" + e.getMessage());
			session.getTransaction().rollback();
			System.out.println("failure");
			return "failure" ;
		}
		System.out.println("success");
		return "success";
	}

}
