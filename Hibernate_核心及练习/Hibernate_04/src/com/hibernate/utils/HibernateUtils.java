package com.hibernate.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate的工具类
 * @author Host
 * */
public class HibernateUtils {
	private static final Configuration cfg;
	private static final SessionFactory sf;
	
	static{
		cfg = new Configuration().configure();
		sf = cfg.buildSessionFactory();
	}
	
	public static Session openSession(){
		return sf.openSession();
	}
}
