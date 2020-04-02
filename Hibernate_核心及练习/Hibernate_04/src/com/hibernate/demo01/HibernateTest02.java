package com.hibernate.demo01;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hibernate.utils.HibernateUtils;

/**
 * 持久化的三种状态：
 * */
public class HibernateTest02 {
//	@Test
//	public void demo01(){
//		Session session = HibernateUtils.openSession();
//		Transaction tx = session.beginTransaction();
//		
//		Customer customer = new Customer();
//		customer.setCust_name("往东");
//		Serializable id = session.save(customer);
//		session.get(Customer.class,id);
//		
//		tx.commit();
//		session.close();
//		System.out.println("客户名称："+customer.getCust_name());		
//	}
	
	
	@Test
	//持久态对象自动更新数据库
	public void demo02(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
				
		//获得持久态对象
		Customer customer = session.get(Customer.class, 1l);
		customer.setCust_name("往东");
		
		tx.commit();
		session.close();	
	}
}
