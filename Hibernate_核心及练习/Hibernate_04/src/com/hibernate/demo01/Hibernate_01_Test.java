package com.hibernate.demo01;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class Hibernate_01_Test {

	@Test
	public void test() {
		System.out.println("���Խڵ�1");
		
		//1.����hibernate�ĺ��������ļ�
		Configuration configuration = new Configuration().configure();
		System.out.println("���Խڵ�2");
		
		//2.����SessionFaction����������JDBC�е����ӳ�
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		System.out.println("���Խڵ�3");
		
		//3.ͨ��SessionFactory����session����������JDBC�е�connection
		Session session = sessionFactory.openSession();
		
		//4.�ֶ�������
		Transaction transaction = session.beginTransaction();
		
		//5.ִ�д���
		//�������뿪ʼ
		Customer customer = new Customer();
		customer.setCust_name("�������");
		session.save(customer);
		//�����������
		
		//6.�ύ����
		transaction.commit();
		
		//7.�ر���Դ
		session.close();
		sessionFactory.close();		
	}

}
