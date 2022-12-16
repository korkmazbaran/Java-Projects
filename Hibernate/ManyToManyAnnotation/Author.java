package domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "AUTHOR")
public class Author {
	@SequenceGenerator(name = "author", sequenceName = "AUTHOR_ID_SEQ")
	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "author", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "NAME", length = 100)
	private String name;
	
	@ManyToMany(
	fetch = FetchType.LAZY,
	cascade = CascadeType.ALL,
	mappedBy = "authories"
	)
	private Set<Book> books = new HashSet<Book>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
}
