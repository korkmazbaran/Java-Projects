package app;

import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.*;
import hibernate.HibernateUtil;

public class OTOApp {
	public static void main(String[] args) {
		Person person = new Person();
		person.setName("Baran");
		
		FingerPrint fingerPrint = new FingerPrint();
		fingerPrint.setFileNo("25A");
		fingerPrint.setPerson(person);
		person.setFingerPrint(fingerPrint);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		fingerPrint = (FingerPrint) session.merge(fingerPrint);
		
		transaction.commit();
		
		FingerPrint fingerPrint1 = session.get(FingerPrint.class, fingerPrint.getId());
		
		Person person1 = null;
		if (fingerPrint1 != null) {
			person1 = fingerPrint1.getPerson();
		}
		
		FingerPrint fingerPrint2 = null;
		if (person1 != null) {
			Person person2 = session.find(Person.class, person1.getId());
			if (person2 != null) {
				fingerPrint2 = person2.getFingerPrint();
			}
		}
		
		System.out.println(person1.getName());
		System.out.println(fingerPrint2.getFileNo());
	}
}
