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
	 * Hibernated������API
	 * */
//	@Test
//	/**
//	 * Query �򵥲�ѯ
//	 * */
//	public void demo01(){
//		Session session = HibernateUtils.getCurrentSession();
//		Transaction tx = session.beginTransaction();
//		
////		//ͨ��Session���Query�ӿ�
////		String hql = "from Customer";
//		//������ѯ
//		String hql = "from Customer where cust_name like ?";		
//		
//		Query query = session.createQuery(hql);
//		//�����������
//		query.setParameter(0, "��%");	
//		//���÷�ҳ���
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
//	 * Query ��ҳ��ѯ
//	 * */
//	public void demo01(){
//		Session session = HibernateUtils.getCurrentSession();
//		Transaction tx = session.beginTransaction();
//		
////		//ͨ��Session���Query�ӿ�
//		String hql = "from Customer";	
//		Query query = session.createQuery(hql);
//		//���÷�ҳ���
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
		
//		//ͨ��Session���Criteria����
//		Criteria criteria = session.createCriteria(Customer.class);
//		List<Customer> list = criteria.list();
		
//		//����������ѯ
//		Criteria criteria = session.createCriteria(Customer.class);
//		criteria.add(Restrictions.like("cust_name", "��%"));
//		List<Customer> list = criteria.list();
		
		//��ҳ��ѯ
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
