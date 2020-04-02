package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hibernate.domain.Customer;
import com.hibernate.domain.LinkMan;
import com.hibernate.utils.HibernateUtils;
/**
 * �����������²�����
 * 	����ͻ�������ϵ�ˣ������������ǿͻ�������Ҫ��Customer.hbm.xml�н�������
 * 	<set name="linkMans" cascade="save-update">
 * */
public class TestDemo04 {
	@Test
	//һ�Զ�ֻ����һ���Ƿ����
	public void demo01(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//���������ͻ�
		Customer customer1 = new Customer();
		customer1.setCust_name("����");
		
		
		//����������ϵ��
		LinkMan lm1 = new LinkMan();
		lm1.setLkm_name("����");		
		
		//���ù�ϵ
		lm1.setCustomer(customer1);
		customer1.getLinkMans().add(lm1);
		
		//��������
//		1.ֻ����ͻ�(�����Ա�һ��˲ʱ�����쳣��һ���־�̬���������һ��˲ʱ̬����)��
//		session.save(customer1);
//		2.ֻ������ϵ��
		session.save(lm1);
		
		
		
		
		tx.commit();
	}
}
