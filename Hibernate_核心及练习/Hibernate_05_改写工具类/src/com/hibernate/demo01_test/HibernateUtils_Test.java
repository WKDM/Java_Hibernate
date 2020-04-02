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
//	//����ͻ�����
//	public void demo01(){
//		Session session = HibernateUtils.openSession();
//		Transaction transaction = session.beginTransaction();
//		
//		//ִ�д���
//		Customer customer = new Customer();
//		customer.setCust_name("��Ů��");
//		session.save(customer);
//		transaction.commit();
//		session.close();		
//	}
	
//	@Test
//	//��ѯ����
//	public void demo02(){
//		Session session = HibernateUtils.openSession();
//		Transaction tx = session.beginTransaction();
//		//��ѯ����
//		//ʹ��get������ѯ
////		Customer customer = session.get(Customer.class,1l);
////		System.out.println(customer); 
//		
//		//ʹ��post������ѯ
//		Customer customer = session.load(Customer.class,2l);
//		System.out.println(customer); 
//		
//		
//		tx.commit();
//		session.close();
//	}
	
//	@Test
//	//�޸Ĳ���
//	public void demo03(){
//		Session session = HibernateUtils.openSession();
//		Transaction tx = session.beginTransaction();
//		//ִ�д���
//		//ֱ�Ӵ������󣬽����޸�
////		Customer customer = new Customer();
////		customer.setCust_id(5l);
////		customer.setCust_name("����");
////		session.update(customer);
//		//�Ȳ�ѯ���޸�
//		Customer customer = session.get(Customer.class,8l);
//		customer.setCust_name("������");
//		session.update(customer);
//		tx.commit();
//		session.close();
//	}
	
//	@Test
//	public void demo04(){
//		Session session = HibernateUtils.openSession();
//		Transaction tx = session.beginTransaction();
//		//ִ�д���
//		//ֱ�Ӵ�������ɾ��
////		Customer customer = new Customer();
////		customer.setCust_id(3l);
////		session.delete(customer);
//		//�Ȳ�ѯ��ɾ��
//		Customer customer = session.get(Customer.class, 1l);
//		session.delete(customer);
//		
//		tx.commit();
//		session.close();
//	}
	
	
//	@Test
//	//��������
//	public void demo05(){
//		Session session = HibernateUtils.openSession();
//		Transaction tx = session.beginTransaction();
//		//ִ�д���
//		//��id���Ǳ���
//		Customer customer = new Customer();
//		customer.setCust_name("����Ԫ");
//		session.saveOrUpdate(customer);
//		//��id���Ǹ���
////		Customer customer = new Customer();
////		customer.setCust_id(2l);
////		customer.setCust_name("����ϼ");
////		session.saveOrUpdate(customer);
//		tx.commit();
//		session.close();
//	}
	
	
	@Test
	//��ѯ��������
	public void demo06(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		
//		//����һ��HQL:Hibernate Query Language �������Ĳ�ѯ����
//		Query query = session.createQuery("from Customer");
//		List<Customer> list = query.list();
//		for(Customer customer:list){
//			System.out.println(customer);
//		}
		
		//����SQL���
		SQLQuery query = session.createSQLQuery("select * from cst_customer");
		List<Object[]> list = query.list();
		for(Object[] objects:list){
			System.out.println(Arrays.toString(objects));
		}
		tx.commit();
		session.close();
	}
	
}
