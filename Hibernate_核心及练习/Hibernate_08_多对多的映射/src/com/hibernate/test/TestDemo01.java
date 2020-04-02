package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hibernate.domain.Customer;
import com.hibernate.domain.LinkMan;
import com.hibernate.utils.HibernateUtils;
/**
 * һ�Զ�Ĳ�����
 * */
public class TestDemo01 {
	@Test
	//����2���ͻ���3����ϵ�ˣ����ҽ����ù�ϵ
	public void demo01(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//���������ͻ�
		Customer customer1 = new Customer();
		customer1.setCust_name("����");
		Customer customer2 = new Customer();
		customer2.setCust_name("����");
		
		//����������ϵ��
		LinkMan lm1 = new LinkMan();
		lm1.setLkm_name("��ʿ��");
		LinkMan lm2 = new LinkMan();
		lm2.setLkm_name("��ë");
		LinkMan lm3 = new LinkMan();
		lm3.setLkm_name("��������");
		
		//���ù�ϵ
		lm1.setCustomer(customer1);
		lm2.setCustomer(customer1);
		lm3.setCustomer(customer2);
		customer1.getLinkMans().add(lm1);
		customer1.getLinkMans().add(lm2);
		customer2.getLinkMans().add(lm3);
		
		//��������
		session.save(customer1);
		session.save(customer2);
		session.save(lm1);
		session.save(lm2);
		session.save(lm3);
		
		
		
		
		tx.commit();
	}
}
