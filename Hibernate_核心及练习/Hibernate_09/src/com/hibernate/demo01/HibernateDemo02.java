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
 * HQL�Ĳ�ѯ��ʽ�Ĳ�����
 * 
 * */
public class HibernateDemo02 {
	@Test
	/**
	 * ��ʼ������
	 * */
	public void demo01(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//����һ���ͻ�
		Customer customer = new Customer();
		customer.setCust_name("����");
		for(int i=1;i<=10;i++){
			LinkMan linkMan = new LinkMan();
			linkMan.setLkm_name("�޼���"+i);
			linkMan.setCustomer(customer);		
			customer.getLinkMans().add(linkMan);
			session.save(linkMan);
		}		
		session.save(customer);
		tx.commit();
	}
	
	@Test
	/**
	 * HQL�ļ򵥲�ѯ
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
	 * �����ѯ
	 * */
	public void demo03(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//�����ѯ
		//Ĭ�����
//		List<Customer> customers = session.createQuery("from Customer order by cust_id").list();
		//����ʹ��desc,�������asc
		List<Customer> customers = session.createQuery("from Customer order by cust_id desc").list();
		for(Customer customer:customers){
			System.out.println(customer);
		}
		
		tx.commit();
	}
	
	@Test
	/**
	 * ������ѯ
	 * */
	public void demo04(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//������ѯ
		//һ����λ�ð�
//		Query query = session.createQuery("from Customer where cust_name = ?");
//		query.setParameter(0,"����");
//		List<Customer> list = query.list();
		
		
//		Query query = session.createQuery("from Customer where cust_name = ?");
//		query.setParameter(0,"����");
//		List<Customer> list = query.list();
		
		
		//���������ư�
		Query query = session.createQuery("from Customer where cust_name like :aaa");
		query.setParameter("aaa","%��");
		List<Customer> list = query.list();
		
		
		
		
		for(Customer customer:list){
			System.out.println(customer);
		}
		
		tx.commit();
	}
	
	@Test
	/**
	 * ͶӰ��ѯ
	 * */
	public void demo05(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//ͶӰ��ѯ
//		//��������
//		List<Object> list = session.createQuery("select c.cust_id from Customer c").list();		
//		for(Object object:list){
//			System.out.println(object);
//		}
//		//������ԣ�
//		List<Object[]> list = session.createQuery("select c.cust_id,c.cust_name,c.cust_source from Customer c").list();
//		for(Object[] objects : list){
//			System.out.println(Arrays.toString(objects));
//		}
		
		//��ѯ������ԣ����������װ��������ȥ
		List<Customer> list = session.createQuery("select new Customer(cust_name,cust_source) from Customer").list();
		for(Customer customer:list){
			System.out.println(customer);
		}
		
		
		tx.commit();
	}
	
	
	@Test
	/**
	 * ��ҳ��ѯ
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
	 * ����ͳ�Ʋ�ѯ
	 * */
	public void demo07(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
//		//�ۺϺ�����ʹ�ã�count(),max(),min(),avg(),sum()
//		Object object = session.createQuery("select count(*) from Customer").uniqueResult();
//		System.out.println(object);
		List<Object[]> list = session.createQuery("select cust_source,count(*) from Customer group by cust_source Having count(*)>=2").list();
		for(Object[] obj:list){
			System.out.println(Arrays.toString(obj));
		}
		
		tx.commit();
	}
	
}
