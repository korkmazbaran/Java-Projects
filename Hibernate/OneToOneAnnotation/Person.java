package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON")
public class Person {
	
	@SequenceGenerator(name ="person",sequenceName = "PERSON_ID_SEQ")
	@Id
	@GeneratedValue(generator = "person",strategy = GenerationType.SEQUENCE)
	@Column(name="ID")
	private Long id;
	@Column(name="NAME",length = 100)
	private String name;
	
	@OneToOne(
	fetch = FetchType.LAZY,
	optional = false,
	mappedBy = "person"
	
	)
	private FingerPrint fingerPrint;

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

	public FingerPrint getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(FingerPrint fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

}
