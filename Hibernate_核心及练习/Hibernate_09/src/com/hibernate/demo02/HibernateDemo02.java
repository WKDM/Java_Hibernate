package com.hibernate.demo02;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hibernate.domain.Customer;
import com.hibernate.domain.LinkMan;
import com.hibernate.utils.HibernateUtils;

/**
 * 	��<set>�ϵ�fetch��lazy
 * */
public class HibernateDemo02 {
	@Test
	/**
	 * Ĭ������� 	
	 * */
	public void Demo01(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//��ѯ1�ſͻ�
		Customer customer = session.get(Customer.class,1l);
		System.out.println(customer.getCust_name());//��һ�����
		//�鿴1�ſͻ���ÿ����ϵ�˵���Ϣ
		for(LinkMan linkman:customer.getLinkMans()){
			System.out.println(linkman.getLkm_name());//����Ҳ��һ�����		
		}
		
		tx.commit();
		
	}
	
	@Test
	/**
	 * Ĭ������� fetch="join" lazy="true"	
	 * */
	public void Demo02(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//��ѯ1�ſͻ�
		Customer customer = session.get(Customer.class,1l);
		System.out.println(customer.getCust_name());//��һ�����
		//�鿴1�ſͻ���ÿ����ϵ�˵���Ϣ
		for(LinkMan linkman:customer.getLinkMans()){
			System.out.println(linkman.getLkm_name());//�ڵ�һ����������£��������		
		}
		
		tx.commit();
		
	}
	
	
	@Test
	/**
	 * Ĭ������� fetch="select" lazy="true"	
	 * */
	public void Demo03(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//��ѯ1�ſͻ�
		Customer customer = session.get(Customer.class,1l);
		System.out.println(customer.getCust_name());//��һ����ѯ�ͻ���SQL
		//�鿴1�ſͻ���ÿ����ϵ�˵���Ϣ
		for(LinkMan linkman:customer.getLinkMans()){
			System.out.println(linkman.getLkm_name());//����һ�����ݿͻ�ID����ѯ��ϵ�˵�SQL	
		}
		
		tx.commit();
		
	}
	@Test
	/**
	 * Ĭ������� fetch="select" lazy="false"	
	 * */
	public void Demo04(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//��ѯ1�ſͻ�
		Customer customer = session.get(Customer.class,1l);//��������SQL��䣺��ѯ�ͻ������ƣ���ѯ�ͻ���������ϵ��
		System.out.println(customer.getCust_name());
		//�鿴1�ſͻ���ÿ����ϵ�˵���Ϣ
		for(LinkMan linkman:customer.getLinkMans()){
			System.out.println(linkman.getLkm_name());//����һ�����ݿͻ�ID����ѯ��ϵ�˵�SQL	
		}
		
		tx.commit();
		
	}
	
}
