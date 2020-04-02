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
 * QBC�Ĳ�ѯ��ʽ�Ĳ�����
 * 
 * */
public class HibernateDemo01 {
	
	@Test
	/**
	 * HQL�ļ򵥲�ѯ
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
	 * �����ѯ
	 * */
	public void demo02(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//�����ѯ
		Criteria criteria = session.createCriteria(Customer.class);
		//��������desc����asc����
		criteria.addOrder(Order.desc("cust_id"));
		List<Customer> list = criteria.list();
		for(Customer customer:list){
			System.out.println(customer);
		}
		tx.commit();
	}
	
	
	@Test
	/**
	 * ��ҳ��ѯ
	 * */
	public void demo03(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(LinkMan.class);
		//���÷�ҳ��ѯ
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
	 * ������ѯ
	 * */
	public void demo04(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();		
		//������ѯ		
		Criteria criteria = session.createCriteria(Customer.class);
		//��������
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
		criteria.add(Restrictions.eq("cust_source","����"));
		List<Customer> list = criteria.list();		
		for(Customer customer:list){
			System.out.println(customer);
		}
		
		tx.commit();
	}
	


	
	@Test
	/**
	 * ����ͳ�Ʋ�ѯ
	 * */
	public void demo05(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();		
		
		Criteria criteria = session.createCriteria(Customer.class);
		/**
		 * add:��ͨ��������where��������
		 * addOrder:����
		 * setProjection:�ۺϺ�����group by having
		 * */
		criteria.setProjection(Projections.rowCount());
		Long num = (Long)criteria.uniqueResult();
		System.out.println(num);
		
		
		tx.commit();
	}
	@Test
	/**
	 * ����������ѯ
	 * */
	public void demo06(){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
		detachedCriteria.add(Restrictions.like("cust_name","��%"));		
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
