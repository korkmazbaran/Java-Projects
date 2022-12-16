package domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CITY")
public class City {
	@SequenceGenerator(name = "city", sequenceName = "CITY_ID_SEQ")
	@GeneratedValue(generator = "city", strategy = GenerationType.SEQUENCE)
	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME", length = 100)
	private String name;
	
	@ManyToOne(
	fetch = FetchType.LAZY,
	cascade = CascadeType.ALL,
	optional = false
	)
	private Country country;

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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}
