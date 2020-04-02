package com.hibernate.helloword;

import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.*;
import org.junit.Test;

public class HibernateTest {

	@Test
	public void test(){
		
		//1.����һ��SessionFactory����
		SessionFactory sessionFactory = null;
		System.out.println("����1");
		//1)����Configuration���󣺶�Ӧhibernate�Ļ�����Ϣ�Ͷ����ϵӳ����Ϣ
		Configuration configuration = new Configuration().configure();
		//4.0֮ǰ
//		sessionFactory = configuration.buildSessionFactory();
		
		//2)����һ��ServiceRegistry����hibernate 4.x����Ӷ���
		//hibernate ���κ����úͷ���������Ҫ�ڸö�����ע��������Ч��
////		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings()
//		
//		ServiceRegistry serviceRegistry = 
//				new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//		//3��
		sessionFactory = configuration.buildSessionFactory();
		//2.����һ��Session����
		Session session = sessionFactory.openSession();
		//3.��������
		Transaction transaction =session.beginTransaction();
		
		//4.ִ�б������
		News news= new News("Java","ATGUIGU",new Date(new java.util.Date().getTime()));
		session.save(news);
		
		//5.�ύ����
		transaction.commit();
		
		//6.�ر�Session
		session.close();
		
		//7.�ر�SessionFactory����
		sessionFactory.close();
		
	}

}
