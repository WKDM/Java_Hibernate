package com.hibernate.demo02;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hibernate.domain.Customer;
import com.hibernate.domain.LinkMan;
import com.hibernate.utils.HibernateUtils;

/**
 * 	在<set>上的fetch和lazy
 * */
public class HibernateDemo02 {
	@Test
	/**
	 * 默认情况： 	
	 * */
	public void Demo01(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//查询1号客户
		Customer customer = session.get(Customer.class,1l);
		System.out.println(customer.getCust_name());//发一条语句
		//查看1号客户的每个联系人的信息
		for(LinkMan linkman:customer.getLinkMans()){
			System.out.println(linkman.getLkm_name());//这里也发一条语句		
		}
		
		tx.commit();
		
	}
	
	@Test
	/**
	 * 默认情况： fetch="join" lazy="true"	
	 * */
	public void Demo02(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//查询1号客户
		Customer customer = session.get(Customer.class,1l);
		System.out.println(customer.getCust_name());//发一条语句
		//查看1号客户的每个联系人的信息
		for(LinkMan linkman:customer.getLinkMans()){
			System.out.println(linkman.getLkm_name());//在第一条语句条件下，发送语句		
		}
		
		tx.commit();
		
	}
	
	
	@Test
	/**
	 * 默认情况： fetch="select" lazy="true"	
	 * */
	public void Demo03(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//查询1号客户
		Customer customer = session.get(Customer.class,1l);
		System.out.println(customer.getCust_name());//发一条查询客户的SQL
		//查看1号客户的每个联系人的信息
		for(LinkMan linkman:customer.getLinkMans()){
			System.out.println(linkman.getLkm_name());//发送一条根据客户ID，查询联系人的SQL	
		}
		
		tx.commit();
		
	}
	@Test
	/**
	 * 默认情况： fetch="select" lazy="false"	
	 * */
	public void Demo04(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//查询1号客户
		Customer customer = session.get(Customer.class,1l);//发送两条SQL语句：查询客户的名称，查询客户关联的联系人
		System.out.println(customer.getCust_name());
		//查看1号客户的每个联系人的信息
		for(LinkMan linkman:customer.getLinkMans()){
			System.out.println(linkman.getLkm_name());//发送一条根据客户ID，查询联系人的SQL	
		}
		
		tx.commit();
		
	}
	
}
