package app;

import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.City;
import domain.Country;
import hibernate.HibernateUtil;

public class OTMApp {
	public static void main(String[] args) {
		
		Country country = new Country();
		country.setName("Turkey");

		City city = new City();
		city.setName("Istanbul");
		city.setCountry(country);
		
		City city2 = new City();
		city.setName("Sivas");
		city2.setCountry(country);
		
		country.getCities().add(city);
		country.getCities().add(city2);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		session.merge(country);
		
		transaction.commit();

	}

}
