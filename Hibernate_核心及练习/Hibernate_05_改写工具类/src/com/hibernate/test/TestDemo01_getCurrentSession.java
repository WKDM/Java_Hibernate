package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hibernate.demo01.Customer;
import com.hibernate.utils.HibernateUtils;

public class TestDemo01_getCurrentSession {
	@Test
	public void demo01(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = new Customer();
		customer.setCust_name("ÍõÏþ¶«");
		session.saveOrUpdate(customer);
		
		tx.commit();
	}
}
