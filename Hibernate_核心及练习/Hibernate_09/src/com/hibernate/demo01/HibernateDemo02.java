package com.hibernate.demo01;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hibernate.domain.Customer;
import com.hibernate.domain.LinkMan;
import com.hibernate.utils.HibernateUtils;

/**
 * HQL的查询方式的测试类
 * 
 * */
public class HibernateDemo02 {
	@Test
	/**
	 * 初始化数据
	 * */
	public void demo01(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//创建一个客户
		Customer customer = new Customer();
		customer.setCust_name("王可");
		for(int i=1;i<=10;i++){
			LinkMan linkMan = new LinkMan();
			linkMan.setLkm_name("罗佳玉"+i);
			linkMan.setCustomer(customer);		
			customer.getLinkMans().add(linkMan);
			session.save(linkMan);
		}		
		session.save(customer);
		tx.commit();
	}
	
	@Test
	/**
	 * HQL的简单查询
	 * */
	public void demo02(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from Customer");
		List<Customer> list = query.list();
		for(Customer customer:list){
			System.out.println(customer);
		}
		
		tx.commit();
	}
	
	
	@Test
	/**
	 * 排序查询
	 * */
	public void demo03(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//排序查询
		//默认情况
//		List<Customer> customers = session.createQuery("from Customer order by cust_id").list();
		//降序使用desc,升序就用asc
		List<Customer> customers = session.createQuery("from Customer order by cust_id desc").list();
		for(Customer customer:customers){
			System.out.println(customer);
		}
		
		tx.commit();
	}
	
	@Test
	/**
	 * 条件查询
	 * */
	public void demo04(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//条件查询
		//一、按位置绑定
//		Query query = session.createQuery("from Customer where cust_name = ?");
//		query.setParameter(0,"王可");
//		List<Customer> list = query.list();
		
		
//		Query query = session.createQuery("from Customer where cust_name = ?");
//		query.setParameter(0,"王可");
//		List<Customer> list = query.list();
		
		
		//二、按名称绑定
		Query query = session.createQuery("from Customer where cust_name like :aaa");
		query.setParameter("aaa","%红");
		List<Customer> list = query.list();
		
		
		
		
		for(Customer customer:list){
			System.out.println(customer);
		}
		
		tx.commit();
	}
	
	@Test
	/**
	 * 投影查询
	 * */
	public void demo05(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//投影查询
//		//单个属性
//		List<Object> list = session.createQuery("select c.cust_id from Customer c").list();		
//		for(Object object:list){
//			System.out.println(object);
//		}
//		//多个属性：
//		List<Object[]> list = session.createQuery("select c.cust_id,c.cust_name,c.cust_source from Customer c").list();
//		for(Object[] objects : list){
//			System.out.println(Arrays.toString(objects));
//		}
		
		//查询多个属性，但是我想封装到对象中去
		List<Customer> list = session.createQuery("select new Customer(cust_name,cust_source) from Customer").list();
		for(Customer customer:list){
			System.out.println(customer);
		}
		
		
		tx.commit();
	}
	
	
	@Test
	/**
	 * 分页查询
	 * */
	public void demo06(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from LinkMan");
		query.setFirstResult(0);
		query.setMaxResults(5);
		query.list();
		List<LinkMan> list = query.list();
		for(LinkMan linkman:list){
			System.out.println(linkman);
		}
		
		
		tx.commit();
	}
	
	@Test
	/**
	 * 分组统计查询
	 * */
	public void demo07(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
//		//聚合函数的使用：count(),max(),min(),avg(),sum()
//		Object object = session.createQuery("select count(*) from Customer").uniqueResult();
//		System.out.println(object);
		List<Object[]> list = session.createQuery("select cust_source,count(*) from Customer group by cust_source Having count(*)>=2").list();
		for(Object[] obj:list){
			System.out.println(Arrays.toString(obj));
		}
		
		tx.commit();
	}
	
}
