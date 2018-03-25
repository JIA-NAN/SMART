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
//	    //创建sessionFactory  
//	    static  
//	    {  
//	        try  
//	        {  
//	            // 采用默认的hibernate.cfg.xml来启动一个Configuration的实例  
//	            Configuration cfg = new Configuration()  
//	                .configure("/hibernate.cfg.xml");
//	            // 以Configuration实例来创建SessionFactory实例  
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
//	    // ThreadLocal可以隔离多个线程的数据共享，因此不再需要对线程同步  
//	    public static final ThreadLocal<Session> session  
//	        = new ThreadLocal<Session>();  
//	    //创建Session  
//	    public static Session currentSession()  
//	        throws HibernateException  
//	    {  
//	        //通过线程对象.get()方法安全创建Session  
//	        Session s = session.get();  
//	        // 如果该线程还没有Session,则创建一个新的Session  
//	        if (s == null)  
//	        {  
//	            s = sessionFactory.openSession();  
//	            // 将获得的Session变量存储在ThreadLocal变量session里  
//	            session.set(s);  
//	        }  
//	        return s;  
//	    }  
//	    //关闭Session  
//	    public static void closeSession()  
//	        throws HibernateException  
//	    {  
//	        Session s = session.get();  
//	        if (s != null)  
//	            s.close();  
//	        session.set(null);  
//	    }  
}
