package com.hackersanon.banqi.database;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DaoSessionFactory
{
	private static final SessionFactory sFactory;
	
	static{
		Configuration configuration = new org.hibernate.cfg.Configuration().configure();
		
		try{
			sFactory = new Configuration().configure().buildSessionFactory();
		}
		catch (HibernateException e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static SessionFactory getSessionFactory()
	{
		return sFactory;
	}
}
