package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hibernate.domain.Role;
import com.hibernate.domain.User;
import com.hibernate.utils.HibernateUtils;
/**
 * hibernate：多对多的映射
 * */
public class TestDemo06 {
	
	@Test
	/**
	 * 保存多条记录：保存多个用户和角色
	 * */
	public void demo01(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//创建两个用户
		User user1 = new User();
		user1.setUser_name("王克");
		User user2 = new User();
		user2.setUser_name("王雨");
		
		//创建三个角色
		Role role1 = new Role();
		role1.setRole_name("研发部");
		Role role2 = new Role();
		role2.setRole_name("市场部");
		Role role3 = new Role();
		role3.setRole_name("公关部");
		
		
		//设置双向的关联关系
		user1.getRoles().add(role1);
		user1.getRoles().add(role2);
		user2.getRoles().add(role2);
		user2.getRoles().add(role3);
		role1.getUsers().add(user1);
		role1.getUsers().add(user2);
		role3.getUsers().add(user2);
		
		//保存操作：多对多建立了双向的关系必须有一方放弃外键维护
		//一般是被动方放弃外键维护权
		session.save(role3);
		session.save(role2);
		session.save(role1);
		session.save(user2);
		session.save(user1);
		
		
		
		tx.commit();
	}
}
