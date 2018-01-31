package com.keylesson.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.keylesson.hibernate.HibernateUtil;
import com.keylesson.persistence.Category;
import com.keylesson.persistence.Product;
import com.keylesson.persistence.Purchase;
import com.keylesson.persistence.User;

public class ProductDaoTest {
	private static ProductDAO productDAO;
	private static CategoryDAO categoryDAO;
	private static PurchaseDAO purchaseDAO;
	private static UserDAO userDAO;

	@BeforeClass
	public static void init() {
		System.out.println("method init");
		HibernateUtil.buildSessionFactory();
		Session session = HibernateUtil.getSession();
		categoryDAO = new CategoryDAO(session);
		productDAO = new ProductDAO(session);
		purchaseDAO = new PurchaseDAO(session);
		userDAO = new UserDAO(session);
	}
	
    @AfterClass
    public static void shutdown() {
        System.out.println("method shutdown");
        HibernateUtil.shutdown();
    }

	@Before
	public void beforeEachTest() {
		System.out.println("This is executed before each Test");
	}

	@After
	public void afterEachTest() {
		System.out.println("This is executed after each Test");
	}
	
	@Test(expected = Exception.class)
	public void testDivisionException() throws Exception {
		int x = 0;
		int y = 10;
		double z = 1d;
		z = x / y;
		System.out.println(z);
	}

	@Ignore
	@Test
	public void testSubstraction() {
		int result = 10 - 3;
		assertTrue(result == 9);
	}
	
	@Test
	public void testHibernateCRUD() {
		System.out.println("method testHibernateCRUD");
		//cleanDatabase();
		User user = addUser();
		addPurchase(user);
		//create();
		//get();
		//delete();
	}
	
	private void cleanDatabase() {
		System.out.println("method cleanDatabase");
		List<Product> products = productDAO.getAllProducts();
		for(Product p : products) {
			productDAO.delete(p.getId());
		}
		List<Category> categories = categoryDAO.getAllCategories();
		for(Category c : categories) {
			categoryDAO.delete(c.getId());
		}
	}
	
	private void create() {
		System.out.println("method create");
		//Category category = categoryDAO.create("agua e sal", "bolachas de agua e sal");
		Category category = new Category("agua e sal", "bolachas de agua e sal");
		Set<Category> categories = new HashSet<Category>();
		categories.add(category);
		Product product = new Product("cream cracker", 8.01, categories);
		productDAO.save(product);
		//Product product = productDAO.create("cream cracker", 8.01, categories);

		assertEquals(1, product.getId());
	}
	
	private void addPurchase(User user) {
		System.out.println("method addPurchase");
		Date date = new Date();
		String paid = "S";
		double totalPrice = 0d;
		Purchase purchase = new Purchase();
		purchase.setDate(date);
		purchase.setPaid(paid);
		purchase.setTotalPrice(totalPrice);
		purchase.setUser(user);
		purchaseDAO.save(purchase);
	}
	
	private User addUser() {
		System.out.println("method addUser");
		User user = new User();
		user.setLogin("aaa");
		user.setName("aaa bbb");
		user.setEmail("aaa@gmail.com");
		user.setPassword("123");
		userDAO.save(user);
		return user;
	}

	private void get() {
		System.out.println("method get");
		Product product = productDAO.get(1);
		Category category = categoryDAO.get(1);

		assertEquals(1, product.getId());
		assertEquals("cream cracker", product.getName());
		
		assertEquals(1, category.getId());
		assertEquals("agua e sal", category.getName());
		
		System.out.println("product : "+ product.getName() + " category: " + category.getName());
	}
	
	private void delete() {
		System.out.println("method delete");
		productDAO.delete(1);
		categoryDAO.delete(1);

		assertEquals(0, productDAO.count().intValue());
		assertEquals(0, categoryDAO.count().intValue());
	}

}