package main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class HibernateUtil {
 //  private static SessionFactory sessionFactory;
 //  private static ServiceRegistry serviceRegistry;

 /*  public static SessionFactory createSessionFactory() throws HibernateException {
      Configuration configuration = new Configuration();
      configuration.addClass(Zaposleni.class);
      //   configuration.addResource("zaposleni.hbm.xml");

      configuration.configure();
      serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
              .build();
      sessionFactory = configuration.buildSessionFactory(serviceRegistry);
      return sessionFactory;
   }
public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
   public static void close() {
      sessionFactory.close();
   }*/
private static final SessionFactory sessionFactory;
	static {
		try {
			sessionFactory = new Configuration().configure()
					.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("SessionFactory creation failed" + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}

