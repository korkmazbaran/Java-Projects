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
@Table(name = "BOOK")
public class Book {
	@SequenceGenerator(name = "book", sequenceName = "BOOK_ID_SEQ")
	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "book", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "NAME", length = 100)
	private String name;
	@ManyToMany(
	cascade = CascadeType.ALL,
	fetch = FetchType.LAZY,
	targetEntity = Author.class	
	)
	private Set authories = new HashSet();
	
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
	public Set getAuthories() {
		return authories;
	}
	public void setAuthories(Set authories) {
		this.authories = authories;
	}

}
