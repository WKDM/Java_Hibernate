package com.hibernate.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.hibernate.demo01.Customer;
import com.hibernate.utils.HibernateUtils;

public class TestDemo02_OthersAPI {
	/**
	 * Hibernated的其他API
	 * */
//	@Test
//	/**
//	 * Query 简单查询
//	 * */
//	public void demo01(){
//		Session session = HibernateUtils.getCurrentSession();
//		Transaction tx = session.beginTransaction();
//		
////		//通过Session获得Query接口
////		String hql = "from Customer";
//		//条件查询
//		String hql = "from Customer where cust_name like ?";		
//		
//		Query query = session.createQuery(hql);
//		//设置条件语句
//		query.setParameter(0, "王%");	
//		//设置分页语句
//		query.setFirstResult(0);
//		query.setMaxResults(1);	
//		
//		List<Customer> list = query.list();
//		for(Customer customer:list){
//			System.out.println(customer);
//		}		
//		tx.commit();
//	}
	
//	@Test
//	/**
//	 * Query 分页查询
//	 * */
//	public void demo01(){
//		Session session = HibernateUtils.getCurrentSession();
//		Transaction tx = session.beginTransaction();
//		
////		//通过Session获得Query接口
//		String hql = "from Customer";	
//		Query query = session.createQuery(hql);
//		//设置分页语句
//		query.setFirstResult(0);
//		query.setMaxResults(1);
//		
//		List<Customer> list = query.list();
//		for(Customer customer:list){
//			System.out.println(customer);
//		}		
//		tx.commit();
//	}
//	
	
	
	
	@Test
	/**
	 * Criteria
	 * 
	 * */
	public void demo02(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
//		//通过Session获得Criteria对象
//		Criteria criteria = session.createCriteria(Customer.class);
//		List<Customer> list = criteria.list();
		
//		//按照条件查询
//		Criteria criteria = session.createCriteria(Customer.class);
//		criteria.add(Restrictions.like("cust_name", "往%"));
//		List<Customer> list = criteria.list();
		
		//分页查询
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.setFirstResult(0);
		criteria.setMaxResults(1);
		List<Customer> list = criteria.list();
		
		for(Customer customer:list){
			System.out.println(customer);
		}	
		
		tx.commit();
	}
//	
//	
//	
//	@Test
//	/**
//	 * SQLQuery
//	 * */
//	public void demo03(){
//		Session session = HibernateUtils.getCurrentSession();
//		Transaction tx = session.beginTransaction();
//		
//		tx.commit();
//	}
}
