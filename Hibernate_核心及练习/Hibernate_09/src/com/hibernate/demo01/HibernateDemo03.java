package com.hibernate.demo01;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hibernate.domain.Customer;
import com.hibernate.utils.HibernateUtils;

public class HibernateDemo03 {
	@Test
	/**
	 * HQL的多表查询
	 * */
	public void demo01(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//SQL:select * from cst_customer c Inner Join cst_linkman 1 on c.cust_id;
		//HQL:内链接from Customer c inner join c.linkMans
//		List<Object[]> list = session.createCriteria("from Customer c inner join c.linkMans").list();
//		for(Object[] object:list){
//			System.out.println(Arrays.toString(object));
//		}
		
		//HQL:迫切内链接 其实就在普通的内链接inner join后添加一个关键字fetch。from Customer c inner join fetch c.linkMans
		List<Customer> list = session.createQuery("select distinct c from Customer c inner join fetch c.linkMans").list();//通知hibernate，将另一个对象的数据封装到该对象中
		for(Customer Object:list){
			System.out.println(Object);
		}
		tx.commit();
	}
}
