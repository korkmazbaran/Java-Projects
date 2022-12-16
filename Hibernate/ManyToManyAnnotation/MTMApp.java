package app;


import java.util.HashSet;
import java.util.Set;

import org.hibernate.*;

import domain.Author;
import domain.Book;
import hibernate.HibernateUtil;

public class MTMApp {
	public static void main(String[] args) {
		
		Book book = new Book();
		book.setName("Çalıkuşu");
		
		Author author = new Author();
		author.setName("Yaşar Nuri Güntekin");
		
		book.getAuthories().add(author);
		author.getBooks().add(book);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		book = (Book) session.merge(book);
		
		transaction.commit();
		
		Book book1 = session.find(Book.class, book.getId());
	 	Set authories1 = book1.getAuthories();
	 	
	 	Set<Book> bookSet = new HashSet<Book>();
	 	for (Object author1 : authories1) {
			Author author2 = (Author) author1;
			System.out.println(author2.getName());
			bookSet.addAll(author2.getBooks());
		}
	 	for (Book book2 : bookSet) {
			System.out.println(book2.getName());
		}
	}
}
