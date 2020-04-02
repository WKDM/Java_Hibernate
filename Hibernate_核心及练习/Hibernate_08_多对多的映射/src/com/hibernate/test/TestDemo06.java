package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hibernate.domain.Role;
import com.hibernate.domain.User;
import com.hibernate.utils.HibernateUtils;
/**
 * hibernate����Զ��ӳ��
 * */
public class TestDemo06 {
	
	@Test
	/**
	 * ���������¼���������û��ͽ�ɫ
	 * */
	public void demo01(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//���������û�
		User user1 = new User();
		user1.setUser_name("����");
		User user2 = new User();
		user2.setUser_name("����");
		
		//����������ɫ
		Role role1 = new Role();
		role1.setRole_name("�з���");
		Role role2 = new Role();
		role2.setRole_name("�г���");
		Role role3 = new Role();
		role3.setRole_name("���ز�");
		
		
		//����˫��Ĺ�����ϵ
		user1.getRoles().add(role1);
		user1.getRoles().add(role2);
		user2.getRoles().add(role2);
		user2.getRoles().add(role3);
		role1.getUsers().add(user1);
		role1.getUsers().add(user2);
		role3.getUsers().add(user2);
		
		//�����������Զཨ����˫��Ĺ�ϵ������һ���������ά��
		//һ���Ǳ������������ά��Ȩ
		session.save(role3);
		session.save(role2);
		session.save(role1);
		session.save(user2);
		session.save(user1);
		
		
		
		tx.commit();
	}
}
