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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;




@Entity
@Table(name = "COUNTRY")
public class Country {
	@SequenceGenerator(name="country", sequenceName = "COUNTRY_ID_SEQ")
	@GeneratedValue(generator = "country", strategy = GenerationType.SEQUENCE)
	@Id
	@Column(name = "ID")
	private Long id;
	@Column(name ="NAME" , length = 100)
	private String name;
	
	
	@OneToMany(
	fetch = FetchType.LAZY,
	cascade = CascadeType.ALL,
	targetEntity = City.class,
	mappedBy = "country"
	)
	private Set cities = new HashSet();
	
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
	public Set getCities() {
		return cities;
	}
	public void setCities(Set cities) {
		this.cities = cities;
	}

}
