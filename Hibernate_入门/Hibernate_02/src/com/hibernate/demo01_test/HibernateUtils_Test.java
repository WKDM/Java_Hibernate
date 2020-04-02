package com.hibernate.demo01_test;


import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.sql.Update;
import org.junit.Test;

import com.hibernate.demo01.Customer;
import com.hibernate.utils.HibernateUtils;
import com.mysql.fabric.xmlrpc.base.Array;

public class HibernateUtils_Test {
	
//	@Test
//	//保存客户案例
//	public void demo01(){
//		Session session = HibernateUtils.openSession();
//		Transaction transaction = session.beginTransaction();
//		
//		//执行代码
//		Customer customer = new Customer();
//		customer.setCust_name("咯女人");
//		session.save(customer);
//		transaction.commit();
//		session.close();		
//	}
	
//	@Test
//	//查询案例
//	public void demo02(){
//		Session session = HibernateUtils.openSession();
//		Transaction tx = session.beginTransaction();
//		//查询代码
//		//使用get方法查询
////		Customer customer = session.get(Customer.class,1l);
////		System.out.println(customer); 
//		
//		//使用post方法查询
//		Customer customer = session.load(Customer.class,2l);
//		System.out.println(customer); 
//		
//		
//		tx.commit();
//		session.close();
//	}
	
//	@Test
//	//修改操作
//	public void demo03(){
//		Session session = HibernateUtils.openSession();
//		Transaction tx = session.beginTransaction();
//		//执行代码
//		//直接创建对象，进行修改
////		Customer customer = new Customer();
////		customer.setCust_id(5l);
////		customer.setCust_name("王聪");
////		session.update(customer);
//		//先查询在修改
//		Customer customer = session.get(Customer.class,8l);
//		customer.setCust_name("王海燕");
//		session.update(customer);
//		tx.commit();
//		session.close();
//	}
	
//	@Test
//	public void demo04(){
//		Session session = HibernateUtils.openSession();
//		Transaction tx = session.beginTransaction();
//		//执行代码
//		//直接创建对象，删除
////		Customer customer = new Customer();
////		customer.setCust_id(3l);
////		session.delete(customer);
//		//先查询再删除
//		Customer customer = session.get(Customer.class, 1l);
//		session.delete(customer);
//		
//		tx.commit();
//		session.close();
//	}
	
	
//	@Test
//	//保存或更新
//	public void demo05(){
//		Session session = HibernateUtils.openSession();
//		Transaction tx = session.beginTransaction();
//		//执行代码
//		//无id就是保存
//		Customer customer = new Customer();
//		customer.setCust_name("汪峰元");
//		session.saveOrUpdate(customer);
//		//有id就是更新
////		Customer customer = new Customer();
////		customer.setCust_id(2l);
////		customer.setCust_name("王凤霞");
////		session.saveOrUpdate(customer);
//		tx.commit();
//		session.close();
//	}
	
	
	@Test
	//查询所有数据
	public void demo06(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		
//		//接受一个HQL:Hibernate Query Language 面向对象的查询语言
//		Query query = session.createQuery("from Customer");
//		List<Customer> list = query.list();
//		for(Customer customer:list){
//			System.out.println(customer);
//		}
		
		//接受SQL语句
		SQLQuery query = session.createSQLQuery("select * from cst_customer");
		List<Object[]> list = query.list();
		for(Object[] objects:list){
			System.out.println(Arrays.toString(objects));
		}
		tx.commit();
		session.close();
	}
	
}
