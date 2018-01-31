package com.keylesson.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static Session session;

	public static void initialize() {
		try {
			System.out.println("initialize");
			Configuration config = new Configuration()
					.configure(HibernateUtil.class
							.getResource("/hibernate.cfg.xml"));
			sessionFactory = config.buildSessionFactory();
			sessionFactory.openSession();
		} catch (Throwable ex) {
			System.err.println("Error creating SessionFactory :" + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		System.out.println("getSessionFactory");
		return sessionFactory;
	}
	
	public static Session getSession() {
		System.out.println("getSession");
		return session;
	}

	public static void shutdown() {
		System.out.println("shutdown");
		session.close();
		sessionFactory.close();
	}

	// Create the SessionFactory from hibernate.cfg.xml
    public static void buildSessionFactory() {
        try {
        	System.out.println("buildSessionFactory");
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    

}
