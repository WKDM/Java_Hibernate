package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hibernate.domain.Customer;
import com.hibernate.domain.LinkMan;
import com.hibernate.utils.HibernateUtils;
/**
 * 级联保存或更新操作：
 * 	保存客户级联联系人：操作的主题是客户对象，需要在Customer.hbm.xml中进行配置
 * 	<set name="linkMans" cascade="save-update">
 * */
public class TestDemo04 {
	@Test
	//一对多只保存一边是否可以
	public void demo01(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//创建两个客户
		Customer customer1 = new Customer();
		customer1.setCust_name("王风");
		
		
		//创建三个联系人
		LinkMan lm1 = new LinkMan();
		lm1.setLkm_name("藏獒");		
		
		//设置关系
		lm1.setCustomer(customer1);
		customer1.getLinkMans().add(lm1);
		
		//保存数据
//		1.只保存客户(不可以报一个瞬时对象异常：一个持久态对象关联了一个瞬时态对象)。
//		session.save(customer1);
//		2.只保存联系人
		session.save(lm1);
		
		
		
		
		tx.commit();
	}
}
