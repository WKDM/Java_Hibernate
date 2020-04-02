package com.hibernate.demo02;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hibernate.domain.Customer;
import com.hibernate.utils.HibernateUtils;

public class HibernateDemo01 {
	@Test
	/**
	 * �༶����ӳټ���
	 * ��<class>�ı�ǩ�����õ�lazy
	 * */
	public void demo01(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = session.load(Customer.class,1l);
		Hibernate.initialize(customer);
		System.out.println(customer);
		
		tx.commit();
	}
}
