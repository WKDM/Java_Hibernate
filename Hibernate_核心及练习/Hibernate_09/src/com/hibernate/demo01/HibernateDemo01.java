package com.hibernate.demo01;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.hibernate.domain.Customer;
import com.hibernate.domain.LinkMan;
import com.hibernate.utils.HibernateUtils;

/**
 * QBC的查询方式的测试类
 * 
 * */
public class HibernateDemo01 {
	
	@Test
	/**
	 * HQL的简单查询
	 * */
	public void demo01(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Customer.class);
		List<Customer> list = criteria.list();
		for(Customer customer:list){
			System.out.println(customer);
		}
		
		tx.commit();
	}
	
	
	@Test
	/**
	 * 排序查询
	 * */
	public void demo02(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//排序查询
		Criteria criteria = session.createCriteria(Customer.class);
		//设置排序desc降序，asc降序
		criteria.addOrder(Order.desc("cust_id"));
		List<Customer> list = criteria.list();
		for(Customer customer:list){
			System.out.println(customer);
		}
		tx.commit();
	}
	
	
	@Test
	/**
	 * 分页查询
	 * */
	public void demo03(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(LinkMan.class);
		//设置分页查询
		criteria.setFirstResult(10);
		criteria.setMaxResults(10);
		List<LinkMan> list = criteria.list();
		for(LinkMan linkman:list){
			System.out.println(linkman);
		}
		
		
		tx.commit();
	}
	
	@Test
	/**
	 * 条件查询
	 * */
	public void demo04(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();		
		//条件查询		
		Criteria criteria = session.createCriteria(Customer.class);
		//设置条件
		/**
		 * =	eq
		 * >	gt
		 * >=	ge
		 * <	lt
		 * <=	le
		 * <>	ne
		 * 
		 * like	
		 * in	
		 * and
		 * or
		 * 
		 * */
		criteria.add(Restrictions.eq("cust_source","电视"));
		List<Customer> list = criteria.list();		
		for(Customer customer:list){
			System.out.println(customer);
		}
		
		tx.commit();
	}
	


	
	@Test
	/**
	 * 分组统计查询
	 * */
	public void demo05(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();		
		
		Criteria criteria = session.createCriteria(Customer.class);
		/**
		 * add:普通的条件，where后面条件
		 * addOrder:排序
		 * setProjection:聚合函数和group by having
		 * */
		criteria.setProjection(Projections.rowCount());
		Long num = (Long)criteria.uniqueResult();
		System.out.println(num);
		
		
		tx.commit();
	}
	@Test
	/**
	 * 离线条件查询
	 * */
	public void demo06(){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
		detachedCriteria.add(Restrictions.like("cust_name","李%"));		
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = detachedCriteria.getExecutableCriteria(session);
		List<Customer> list = criteria.list();
		for(Customer customer:list){
			System.out.println(customer);
		}
		
		
		tx.commit();
	}
	
	
}
