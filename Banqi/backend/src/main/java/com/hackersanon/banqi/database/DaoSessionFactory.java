package com.hackersanon.banqi.database;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DaoSessionFactory
{
	private static final SessionFactory sFactory;
	
	static{
		try{

			Configuration configuration = new org.hibernate.cfg.Configuration();
			configuration.configure("hibernate.cfg.xml");
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sFactory = new Configuration().configure().buildSessionFactory(serviceRegistry);
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
