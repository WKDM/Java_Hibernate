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
	 * HQL�Ķ���ѯ
	 * */
	public void demo01(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//SQL:select * from cst_customer c Inner Join cst_linkman 1 on c.cust_id;
		//HQL:������from Customer c inner join c.linkMans
//		List<Object[]> list = session.createCriteria("from Customer c inner join c.linkMans").list();
//		for(Object[] object:list){
//			System.out.println(Arrays.toString(object));
//		}
		
		//HQL:���������� ��ʵ������ͨ��������inner join�����һ���ؼ���fetch��from Customer c inner join fetch c.linkMans
		List<Customer> list = session.createQuery("select distinct c from Customer c inner join fetch c.linkMans").list();//֪ͨhibernate������һ����������ݷ�װ���ö�����
		for(Customer Object:list){
			System.out.println(Object);
		}
		tx.commit();
	}
}
