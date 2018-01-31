package com.keylesson.persistence;

import java.util.Date;

// Generated Jan 26, 2018 12:02:43 AM by Hibernate Tools 5.2.8.Final

/**
 * Purchase generated by hbm2java
 */
public class Purchase implements java.io.Serializable {

	private static final long serialVersionUID = 8396981949110413245L;
	
	private int id;
	private Date date;
	private double totalPrice;
	private String paid;
	private User user;

	public Purchase() {
	}

	public Purchase(int id, Date date, double totalPrice, String paid, User user) {
		this.id = id;
		this.date = date;
		this.totalPrice = totalPrice;
		this.paid = paid;
		this.user = user;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getPaid() {
		return this.paid;
	}

	public void setPaid(String paid) {
		this.paid = paid;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
