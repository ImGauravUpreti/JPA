package com.cognizant;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.cognizant.bean.Product;

/**
 * Hello world!
 *
 */
public class App {

	private static Configuration config = new Configuration();

	public static void main(String[] args) {

		System.out.println("======== Display ALL details ========");
		testGetAllRecords();
		System.out.println("======== Display LAPTOP details ========");
		testLaptopRecords();
		System.out.println("======== Display RAM BASED details ========");
		testRamRecords();
		System.out.println("======== Display CPU BASED details ========");
		testCpuRecords();
		System.out.println("========RAM SIZE=4 and operatingSystem=WINDOWS ====");
		testOsAndRamRecords();
		System.out.println("======== Display OS BASED details ========");
		testOSRecords();
		System.out.println("======== Display Weight BASED details ========");
		testWeightRecords();
		System.out.println("======== Display ID BASED details ========");
		testIdRecords();
		System.out.println("========RAM SIZE=4 and operatingSystem=WINDOWS  and WEIGHT ====");
		testOsRamAndWeightRecords();

	}

	private static void show(List<Product> elist) {
		// TODO Auto-generated method stub
		for (Product product : elist) {
			System.out.println(product);
		}
	}

	private static void testGetAllRecords() {
		config.configure("hibernate.cfg.xml");
		Session session = config.buildSessionFactory().openSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Product> queryObject = criteriaBuilder.createQuery(Product.class);
		Root<Product> root = queryObject.from(Product.class);
		queryObject.select(root);
		TypedQuery<Product> typedQuery = session.createQuery(queryObject);
		List<Product> elist = typedQuery.getResultList();
		show(elist);

	}

	private static void testLaptopRecords() {
		config.configure("hibernate.cfg.xml");
		Session session = config.buildSessionFactory().openSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Product> queryObject = criteriaBuilder.createQuery(Product.class);
		Root<Product> root = queryObject.from(Product.class);
		criteriaBuilder = session.getCriteriaBuilder();
		queryObject = criteriaBuilder.createQuery(Product.class);
		root = queryObject.from(Product.class);
		queryObject.select(root);
		TypedQuery<Product> typedQuery = session.createQuery(queryObject);
		List<Product> elist = typedQuery.getResultList();
		queryObject.where(criteriaBuilder.equal(root.get("productName"), "laptop"));
		typedQuery = session.createQuery(queryObject);
		elist = typedQuery.getResultList();
		show(elist);
	}

	private static void testIdRecords() {
		config.configure("hibernate.cfg.xml");
		Session session = config.buildSessionFactory().openSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Product> queryObject = criteriaBuilder.createQuery(Product.class);
		// EntityType<Product> emp= session.getMetamodel().entity(Product.class);
		Root<Product> root = queryObject.from(Product.class);
		criteriaBuilder = session.getCriteriaBuilder();
		queryObject = criteriaBuilder.createQuery(Product.class);
		root = queryObject.from(Product.class);
		queryObject.select(root);
		TypedQuery<Product> typedQuery = session.createQuery(queryObject);
		List<Product> elist = typedQuery.getResultList();
		queryObject.where(criteriaBuilder.equal(root.get("id"), "1"));
		typedQuery = session.createQuery(queryObject);
		elist = typedQuery.getResultList();
		show(elist);
	}

	private static void testRamRecords() {
		config.configure("hibernate.cfg.xml");
		Session session = config.buildSessionFactory().openSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Product> queryObject = criteriaBuilder.createQuery(Product.class);
		// EntityType<Product> emp= session.getMetamodel().entity(Product.class);
		Root<Product> root = queryObject.from(Product.class);
		criteriaBuilder = session.getCriteriaBuilder();
		queryObject = criteriaBuilder.createQuery(Product.class);
		root = queryObject.from(Product.class);
		queryObject.select(root);
		TypedQuery<Product> typedQuery = session.createQuery(queryObject);
		List<Product> elist = typedQuery.getResultList();
		queryObject.where(criteriaBuilder.equal(root.get("ramSize"), "4"));
		typedQuery = session.createQuery(queryObject);
		elist = typedQuery.getResultList();
		show(elist);
	}

	private static void testCpuRecords() {
		config.configure("hibernate.cfg.xml");
		Session session = config.buildSessionFactory().openSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Product> queryObject = criteriaBuilder.createQuery(Product.class);
		// EntityType<Product> emp= session.getMetamodel().entity(Product.class);
		Root<Product> root = queryObject.from(Product.class);
		criteriaBuilder = session.getCriteriaBuilder();
		queryObject = criteriaBuilder.createQuery(Product.class);
		root = queryObject.from(Product.class);
		queryObject.select(root);
		TypedQuery<Product> typedQuery = session.createQuery(queryObject);
		List<Product> elist = typedQuery.getResultList();
		queryObject.where(criteriaBuilder.equal(root.get("cpu"), "intel"));
		typedQuery = session.createQuery(queryObject);
		elist = typedQuery.getResultList();
		show(elist);
	}

	private static void testOsAndRamRecords() {
		config.configure("hibernate.cfg.xml");
		Session session = config.buildSessionFactory().openSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Product> queryObject = criteriaBuilder.createQuery(Product.class);
		// EntityType<Product> emp= session.getMetamodel().entity(Product.class);
		Root<Product> root = queryObject.from(Product.class);
		criteriaBuilder = session.getCriteriaBuilder();
		queryObject = criteriaBuilder.createQuery(Product.class);
		root = queryObject.from(Product.class);
		queryObject.select(root);
		TypedQuery<Product> typedQuery = session.createQuery(queryObject);
		List<Product> elist = typedQuery.getResultList();
		queryObject.where(criteriaBuilder.and(criteriaBuilder.equal(root.get("ramSize"), "4"),
				criteriaBuilder.equal(root.get("operatingSystem"), "WINDOWS")));
		typedQuery = session.createQuery(queryObject);
		elist = typedQuery.getResultList();
		show(elist);
	}

	private static void testOSRecords() {
		config.configure("hibernate.cfg.xml");
		Session session = config.buildSessionFactory().openSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Product> queryObject = criteriaBuilder.createQuery(Product.class);
		Root<Product> root = queryObject.from(Product.class);
		criteriaBuilder = session.getCriteriaBuilder();
		queryObject = criteriaBuilder.createQuery(Product.class);
		root = queryObject.from(Product.class);
		queryObject.select(root);
		TypedQuery<Product> typedQuery = session.createQuery(queryObject);
		List<Product> elist = typedQuery.getResultList();
		queryObject.where(criteriaBuilder.equal(root.get("operatingSystem"), "WINDOWS"));
		typedQuery = session.createQuery(queryObject);
		elist = typedQuery.getResultList();
		show(elist);
	}

	private static void testWeightRecords() {
		config.configure("hibernate.cfg.xml");
		Session session = config.buildSessionFactory().openSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Product> queryObject = criteriaBuilder.createQuery(Product.class);
		Root<Product> root = queryObject.from(Product.class);
		criteriaBuilder = session.getCriteriaBuilder();
		queryObject = criteriaBuilder.createQuery(Product.class);
		root = queryObject.from(Product.class);
		queryObject.select(root);
		TypedQuery<Product> typedQuery = session.createQuery(queryObject);
		List<Product> elist = typedQuery.getResultList();
		queryObject.where(criteriaBuilder.equal(root.get("weight"), "50"));
		typedQuery = session.createQuery(queryObject);
		elist = typedQuery.getResultList();
		show(elist);
	}

	private static void testOsRamAndWeightRecords() {
		config.configure("hibernate.cfg.xml");
		Session session = config.buildSessionFactory().openSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Product> queryObject = criteriaBuilder.createQuery(Product.class);
		// EntityType<Product> emp= session.getMetamodel().entity(Product.class);
		Root<Product> root = queryObject.from(Product.class);
		criteriaBuilder = session.getCriteriaBuilder();
		queryObject = criteriaBuilder.createQuery(Product.class);
		root = queryObject.from(Product.class);
		queryObject.select(root);
		TypedQuery<Product> typedQuery = session.createQuery(queryObject);
		List<Product> elist = typedQuery.getResultList();
		queryObject.where(
				criteriaBuilder.and(criteriaBuilder.equal(root.get("ramSize"), "4"),
						criteriaBuilder.equal(root.get("operatingSystem"), "WINDOWS"),
				criteriaBuilder.equal(root.get("weight"), "50")));
		typedQuery = session.createQuery(queryObject);
		elist = typedQuery.getResultList();
		show(elist);
	}
}
