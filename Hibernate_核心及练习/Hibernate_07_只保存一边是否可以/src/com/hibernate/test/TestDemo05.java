package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hibernate.domain.Customer;
import com.hibernate.domain.LinkMan;
import com.hibernate.utils.HibernateUtils;
/**
 * ����ɾ��
 * */
public class TestDemo05 {
	@Test
	/**
	 * ����ɾ��
	 * 	ɾ���ͻ�ͬʱ����ɾ����ϵ�ˣ�ɾ���������ǿͻ�����Ҫ��Customer.hbm.xml��������
	 * */
	public void demo01(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//û�����ü���ɾ����Ĭ��������޸�����ϵ�˵������ɾ���ͻ�
		Customer customer = session.get(Customer.class,1l);
		session.delete(customer);
		
		tx.commit();
	}
}
