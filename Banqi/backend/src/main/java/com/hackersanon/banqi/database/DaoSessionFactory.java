package com.hackersanon.banqi.database;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DaoSessionFactory
{
	private static DaoSessionFactory instance = new DaoSessionFactory();

	private SessionFactory sessionFactory;

	private DaoSessionFactory() {
		this.sessionFactory = buildSessionFactory();
	}

	private synchronized static SessionFactory buildSessionFactory() {

			try{
				Configuration configuration = new org.hibernate.cfg.Configuration();
				configuration.configure("hibernate.cfg.xml");
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
				return new Configuration().configure().buildSessionFactory(serviceRegistry);
			}
			catch (HibernateException e) {
				e.printStackTrace();
				throw new ExceptionInInitializerError(e);
			}
	}

	public static SessionFactory getSessionFactory()
	{
		if(instance.sessionFactory == null){
			instance.sessionFactory = buildSessionFactory();
		}
		return instance.sessionFactory;
	}

	public Session getSession(){
		return getSessionFactory().getCurrentSession();
	}
}
