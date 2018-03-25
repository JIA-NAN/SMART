package com.smart.app.tools;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {
	public static SessionFactory sessionFactory;
	public static StandardServiceRegistry standardServiceRegistry;
	static
	{
		try
		{
			if(sessionFactory==null)
			{
				standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
				MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
				Metadata metadata = metadataSources.getMetadataBuilder().build();
				sessionFactory = metadata.getSessionFactoryBuilder().build();
		
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
			if(standardServiceRegistry!=null) {
				StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
			}
		}
	}
	
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
//	 public static final SessionFactory sessionFactory;  
//	    //����sessionFactory  
//	    static  
//	    {  
//	        try  
//	        {  
//	            // ����Ĭ�ϵ�hibernate.cfg.xml������һ��Configuration��ʵ��  
//	            Configuration cfg = new Configuration()  
//	                .configure("/hibernate.cfg.xml");
//	            // ��Configurationʵ��������SessionFactoryʵ��  
//	            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()  
//	                .applySettings(cfg.getProperties()).build();  
//	            sessionFactory = cfg.buildSessionFactory(serviceRegistry);  
//	        }  
//	        catch (Throwable ex)  
//	        {  
//	            System.err.println("Initial SessionFactory creation failed." + ex);  
//	            throw new ExceptionInInitializerError(ex);  
//	        }  
//	    }  
//	  
//	    // ThreadLocal���Ը������̵߳����ݹ�����˲�����Ҫ���߳�ͬ��  
//	    public static final ThreadLocal<Session> session  
//	        = new ThreadLocal<Session>();  
//	    //����Session  
//	    public static Session currentSession()  
//	        throws HibernateException  
//	    {  
//	        //ͨ���̶߳���.get()������ȫ����Session  
//	        Session s = session.get();  
//	        // ������̻߳�û��Session,�򴴽�һ���µ�Session  
//	        if (s == null)  
//	        {  
//	            s = sessionFactory.openSession();  
//	            // ����õ�Session�����洢��ThreadLocal����session��  
//	            session.set(s);  
//	        }  
//	        return s;  
//	    }  
//	    //�ر�Session  
//	    public static void closeSession()  
//	        throws HibernateException  
//	    {  
//	        Session s = session.get();  
//	        if (s != null)  
//	            s.close();  
//	        session.set(null);  
//	    }  
}
