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
		
		//1.创建一个SessionFactory对象
		SessionFactory sessionFactory = null;
		System.out.println("测试1");
		//1)创建Configuration对象：对应hibernate的基本信息和对象关系映射信息
		Configuration configuration = new Configuration().configure();
		//4.0之前
//		sessionFactory = configuration.buildSessionFactory();
		
		//2)创建一个ServiceRegistry对象：hibernate 4.x新添加对象
		//hibernate 的任何配置和服务器都需要在该对象中注册后才能有效。
////		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings()
//		
//		ServiceRegistry serviceRegistry = 
//				new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//		//3）
		sessionFactory = configuration.buildSessionFactory();
		//2.创建一个Session对象
		Session session = sessionFactory.openSession();
		//3.开启事务
		Transaction transaction =session.beginTransaction();
		
		//4.执行保存操作
		News news= new News("Java","ATGUIGU",new Date(new java.util.Date().getTime()));
		session.save(news);
		
		//5.提交事物
		transaction.commit();
		
		//6.关闭Session
		session.close();
		
		//7.关闭SessionFactory对象
		sessionFactory.close();
		
	}

}
