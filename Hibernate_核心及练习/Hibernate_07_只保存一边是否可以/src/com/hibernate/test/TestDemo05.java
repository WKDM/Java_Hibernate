package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hibernate.domain.Customer;
import com.hibernate.domain.LinkMan;
import com.hibernate.utils.HibernateUtils;
/**
 * 级联删除
 * */
public class TestDemo05 {
	@Test
	/**
	 * 级联删除
	 * 	删除客户同时级联删除联系人，删除的主体是客户，需要在Customer.hbm.xml中来配置
	 * */
	public void demo01(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//没有设置级联删除，默认情况：修改了联系人的外键，删除客户
		Customer customer = session.get(Customer.class,1l);
		session.delete(customer);
		
		tx.commit();
	}
}
