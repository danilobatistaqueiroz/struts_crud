package com.keylesson.persistence;
// Generated Jan 25, 2018 5:53:43 PM by Hibernate Tools 5.2.8.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Country generated by hbm2java
 */
public class Country implements java.io.Serializable {

	private static final long serialVersionUID = -4668776037059702652L;
	
	private int id;
	private String name;
    private Set<User> users = new HashSet<User>(0);
    
	public Country() {
	}

	public Country(int id, String name) {
		this.id = id;
		this.name = name;
	}
    public Country(int id, String name, Set<User> users) {
        this.id = id;
        this.name = name;
        this.users = users;
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

    public Set<User> getUsers() {
        return this.users;
    }
    
    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
