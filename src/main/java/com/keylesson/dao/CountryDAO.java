package com.keylesson.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import com.keylesson.persistence.Country;
import com.keylesson.persistence.User;

@SuppressWarnings("unchecked")
public class CountryDAO {
	
	Session session;
	
	public CountryDAO(Session session) {
		this.session = session;
	}

	public Country create(String name, Set<User> users) {
		Country country = new Country();
		try {
			session.beginTransaction();
			country.setName(name);
			country.setUsers(users);
			session.save(country);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error creating Country :" + e.getMessage());
			e.printStackTrace(System.out);
			session.getTransaction().rollback();
			//return "failure" ;
		}
		return country;
	}

	public Country get(Integer id) {
		System.out.println("get country id:"+id);
		Country country = null;
		try {
			country = (Country)session.get(Country.class, id);
		} catch (Exception e) {
			System.err.println("Error getting Countrys :" + e);
			session.getTransaction().rollback();
		}
		return country;
	}
	
	public Integer count() {
		Integer cnt = 0;
		try {
			session.beginTransaction();
			cnt = ( (Long) session.createQuery("select count(*) from Country").iterate().next() ).intValue();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error getting Countries :" + e);
			session.getTransaction().rollback();
		}
		return cnt;
	}
	
	public List<Country> getAllCountries() {
		System.out.println("getAllCountries");
		List<Country> countrys = null;
		try {
			countrys = session.createQuery("from Country").list();
		} catch (Exception e) {
			System.err.println("Error getting all Countriess :" + e);
			session.getTransaction().rollback();
		}
		return countrys;
	}
	
	public List<Country> findByName(String name) {
		List<Country> countrys = null;
		try {
			session.beginTransaction();
			countrys = session
					.createQuery("from Country where name like :name")
					.setParameter("name", "%" + name + "%").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error getting Countrys :" + e);
			session.getTransaction().rollback();
		}
		return countrys;
	}
	
	public List<Country> findByDescription(String description) {
		List<Country> countrys = null;
		try {
			session.beginTransaction();
			countrys = session
					.createQuery("from Country where description like :description")
					.setParameter("description", "%" + description + "%").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error getting Countrys :" + e);
			session.getTransaction().rollback();
		}
		return countrys;
	}

	public String update(Integer id, String name) {
		try {
			System.out.println("CountryDAO update");
			session.beginTransaction();
			Country country = (Country)session.load(Country.class, id);
			country.setName(name);
			session.saveOrUpdate(country);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error creating Country :" + e.getMessage());
			session.getTransaction().rollback();
			System.out.println("failure");
			return "failure" ;
		}
		System.out.println("success");
		return "success";
	}

	public String delete(Integer id) {
		try {
			System.out.println("CountryDAO delete id:"+id);
			session.beginTransaction();
			Country country = (Country)session.get(Country.class,id);
		    session.delete(country);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error deleting Country :" + e.getMessage());
			e.printStackTrace(System.err);
			session.getTransaction().rollback();
			System.out.println("failure");
			return "failure" ;
		}
		System.out.println("success");
		return "success";
	}
}
