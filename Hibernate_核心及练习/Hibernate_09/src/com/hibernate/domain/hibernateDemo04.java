package com.hibernate.domain;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hibernate.utils.HibernateUtils;

/**
 * 批量抓取
 * */
public class hibernateDemo04 {
	@Test
	/**
	 * 根据客户批量抓取联系人
	 * */
	public void demo01(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		List<Customer> list = session.createQuery("from Customer").list();
		for(Customer customer:list){
			System.out.println(customer.getCust_name());
			for(LinkMan linkman:customer.getLinkMans()){
				System.out.println(linkman.getLkm_name());
			}
		}
		
		
		tx.commit();
	}
	
	
	@Test
	/**
	 * 获取联系人的时候抓取客户
	 * 		在Customer.hbm.xml上的<class>上配置
	 * */
	public void demo02(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		List<Customer> list = session.createQuery("from Customer").list();
		for(Customer customer:list){
			System.out.println(customer.getCust_name());
			for(LinkMan linkman:customer.getLinkMans()){
				System.out.println(linkman.getLkm_name());
			}
		}
		
		
		tx.commit();
	}
}
