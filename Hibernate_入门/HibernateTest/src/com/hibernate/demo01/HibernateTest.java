package com.hibernate.demo01;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class HibernateTest {

	@Test
	public void test() {
		System.out.println("≤‚ ‘1");
		Configuration cfg = new Configuration().configure();
		System.out.println("≤‚ ‘2");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println("≤‚ ‘3");
	}

}
