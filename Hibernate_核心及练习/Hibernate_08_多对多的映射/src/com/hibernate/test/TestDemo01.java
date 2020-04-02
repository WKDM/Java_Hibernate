package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hibernate.domain.Customer;
import com.hibernate.domain.LinkMan;
import com.hibernate.utils.HibernateUtils;
/**
 * 一对多的测试类
 * */
public class TestDemo01 {
	@Test
	//保存2个客户；3个联系人，并且建立好关系
	public void demo01(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//创建两个客户
		Customer customer1 = new Customer();
		customer1.setCust_name("王东");
		Customer customer2 = new Customer();
		customer2.setCust_name("张三");
		
		//创建三个联系人
		LinkMan lm1 = new LinkMan();
		lm1.setLkm_name("哈士奇");
		LinkMan lm2 = new LinkMan();
		lm2.setLkm_name("金毛");
		LinkMan lm3 = new LinkMan();
		lm3.setLkm_name("拉布拉多");
		
		//设置关系
		lm1.setCustomer(customer1);
		lm2.setCustomer(customer1);
		lm3.setCustomer(customer2);
		customer1.getLinkMans().add(lm1);
		customer1.getLinkMans().add(lm2);
		customer2.getLinkMans().add(lm3);
		
		//保存数据
		session.save(customer1);
		session.save(customer2);
		session.save(lm1);
		session.save(lm2);
		session.save(lm3);
		
		
		
		
		tx.commit();
	}
}
