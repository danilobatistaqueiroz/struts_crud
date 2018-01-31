package com.keylesson.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.keylesson.persistence.Purchase;
import com.keylesson.persistence.User;

@SuppressWarnings("unchecked")
public class PurchaseDAO {
	
	Session session;
	
	public PurchaseDAO(Session session) {
		this.session = session;
	}

	public Purchase create(Date date, String paid, Double totalPrice, User user) {
		Purchase purchase = new Purchase();
		try {
			session.beginTransaction();
			purchase.setDate(date);
			purchase.setPaid(paid);
			purchase.setTotalPrice(totalPrice);
			purchase.setUser(user);
			session.save(purchase);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error creating Purchase :" + e.getMessage());
			e.printStackTrace(System.out);
			session.getTransaction().rollback();
		}
		return purchase;
	}
	public Purchase save(Purchase purchase) {
		try {
			session.beginTransaction();
			session.save(purchase);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error creating Purchase :" + e.getMessage());
			e.printStackTrace(System.out);
			session.getTransaction().rollback();
		}
		return purchase;
	}

	public Purchase get(Integer id) {
		System.out.println("get purchase id:"+id);
		Purchase purchase = null;
		try {
			purchase = (Purchase)session.get(Purchase.class, id);
		} catch (Exception e) {
			System.err.println("Error getting Purchases :" + e);
			session.getTransaction().rollback();
		}
		return purchase;
	}
	
	public Integer count() {
		Integer cnt = 0;
		try {
			session.beginTransaction();
			cnt = ( (Long) session.createQuery("select count(*) from Purchase").iterate().next() ).intValue();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error getting Purchases :" + e);
			session.getTransaction().rollback();
		}
		return cnt;
	}
	
	public List<Purchase> getAllPurchases() {
		System.out.println("getAllPurchases");
		List<Purchase> purchases = null;
		try {
			purchases = session.createQuery("from Purchase").list();
		} catch (Exception e) {
			System.err.println("Error getting all Purchases :" + e);
			session.getTransaction().rollback();
		}
		return purchases;
	}
	
	public List<Purchase> findByUser(User user) {
		List<Purchase> purchases = null;
		///TODO:complete
		return purchases;
	}
	
	public List<Purchase> findByDate(String date) {
		List<Purchase> purchases = null;
		///TODO:complete
		return purchases;
	}

	public String update(Integer id, Date date, String paid, Double totalPrice) {
		try {
			System.out.println("PurchaseDAO update");
			session.beginTransaction();
			Purchase purchase = (Purchase)session.load(Purchase.class, id);
			purchase.setDate(date);
			purchase.setPaid(paid);
			purchase.setTotalPrice(totalPrice);
			session.saveOrUpdate(purchase);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error creating Purchase :" + e.getMessage());
			session.getTransaction().rollback();
			System.out.println("failure");
			return "failure" ;
		}
		System.out.println("success");
		return "success";
	}

	public String delete(Integer id) {
		try {
			System.out.println("PurchaseDAO delete id:"+id);
			session.beginTransaction();
			Purchase purchase = (Purchase)session.get(Purchase.class,id);
		    session.delete(purchase);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error deleting Purchase :" + e.getMessage());
			e.printStackTrace(System.err);
			session.getTransaction().rollback();
			System.out.println("failure");
			return "failure" ;
		}
		System.out.println("success");
		return "success";
	}
}
