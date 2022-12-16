package app;

import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.City;
import domain.Country;
import hibernate.HibernateUtil;

public class MTOApp {
	public static void main(String[] args) {
		Country country = new Country();
		country.setName("Turkey");

		City city = new City();
		city.setName("Istanbul");
		city.setCountry(country);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.merge(city);
		
		transaction.commit();
	}
}
