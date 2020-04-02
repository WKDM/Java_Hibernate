package com.hibernate.domain;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hibernate.utils.HibernateUtils;

/**
 * ����ץȡ
 * */
public class hibernateDemo04 {
	@Test
	/**
	 * ���ݿͻ�����ץȡ��ϵ��
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
	 * ��ȡ��ϵ�˵�ʱ��ץȡ�ͻ�
	 * 		��Customer.hbm.xml�ϵ�<class>������
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
