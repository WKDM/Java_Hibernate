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
		System.out.println("测试节点1");
		
		//1.加载hibernate的核心配置文件
		Configuration configuration = new Configuration().configure();
		System.out.println("测试节点2");
		
		//2.创建SessionFaction对象；类似于JDBC中的连接池
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		System.out.println("测试节点3");
		
		//3.通过SessionFactory创建session对象；类似于JDBC中的connection
		Session session = sessionFactory.openSession();
		
		//4.手动打开事务
		Transaction transaction = session.beginTransaction();
		
		//5.执行代码
		//操作代码开始
		Customer customer = new Customer();
		customer.setCust_name("王四愣子");
		session.save(customer);
		//操作代码结束
		
		//6.提交事务
		transaction.commit();
		
		//7.关闭资源
		session.close();
		sessionFactory.close();		
	}

}
