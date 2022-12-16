package spring.deneme;

import domain.Pojo;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.util.Date;

public class PojoApp {
	public static void main(String[] args) {
		Date date = new Date();
		Pojo pojo = new Pojo();
		pojo.setName("Baran");
		pojo.setValue(new BigDecimal("5.12"));
		pojo.setDate(date);
		pojo.setTime(date);
		pojo.setDateAndTime(date);
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.merge(pojo);
		transaction.commit();
	}

}
