package com.keylesson.persistence;
// Generated Jan 25, 2018 5:53:43 PM by Hibernate Tools 5.2.8.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Category generated by hbm2java
 */
public class Category implements java.io.Serializable {

	private static final long serialVersionUID = -5298914991996866521L;
	
	private int id;
	private String name;
	private String description;
	private Set<Product> products = new HashSet<Product>(0);
	
	public Category() {
	}

	public Category(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public Category(String name, String description, Set<Product> products) {
		this.name = name;
		this.description = description;
		this.products = products;
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
