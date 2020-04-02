package com.hibernate.demo01;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hibernate.utils.HibernateUtils;

/**
 * �־û�������״̬��
 * */
public class HibernateTest02 {
//	@Test
//	public void demo01(){
//		Session session = HibernateUtils.openSession();
//		Transaction tx = session.beginTransaction();
//		
//		Customer customer = new Customer();
//		customer.setCust_name("����");
//		Serializable id = session.save(customer);
//		session.get(Customer.class,id);
//		
//		tx.commit();
//		session.close();
//		System.out.println("�ͻ����ƣ�"+customer.getCust_name());		
//	}
	
	
	@Test
	//�־�̬�����Զ��������ݿ�
	public void demo02(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
				
		//��ó־�̬����
		Customer customer = session.get(Customer.class, 1l);
		customer.setCust_name("����");
		
		tx.commit();
		session.close();	
	}
}
