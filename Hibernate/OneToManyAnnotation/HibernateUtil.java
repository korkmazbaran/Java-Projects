package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import domain.City;
import domain.Country;



public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(Country.class);
			cfg.addAnnotatedClass(City.class);
			SessionFactory sessionFactory = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
			return sessionFactory;
		} catch (Exception e) {
			System.out.println("Session factory oluştururken  hata oluştu" + e);
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
}
