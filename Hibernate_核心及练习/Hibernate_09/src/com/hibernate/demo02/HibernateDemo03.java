package com.hibernate.demo02;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hibernate.domain.LinkMan;
import com.hibernate.utils.HibernateUtils;

/**
 * many-to-one�ϵ�fetch��lazy����
 * */
public class HibernateDemo03 {
	@Test
	/**
	 * Ĭ��ֵ
	 * */
	public void demo01(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		LinkMan linkMan = session.get(LinkMan.class,1l);
		System.out.println(linkMan.getLkm_name());
		System.out.println(linkMan.getCustomer().getCust_name());
		tx.commit();
	}
}
