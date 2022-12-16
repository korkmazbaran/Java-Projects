package domain;

import javax.persistence.CascadeType;
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
@Table(name = "FINGER_PRINT")
public class FingerPrint {
	@SequenceGenerator(name = "fingerPrint", sequenceName = "FINGER_PRINT_ID_SEQ")
	@Id
	@GeneratedValue(generator = "fingerPrint", strategy = GenerationType.SEQUENCE)
	@Column(name = "ID")
	private Long id;
	@Column(name = "FILE_NO", length = 10)
	private String fileNo;
	
	@OneToOne(
	cascade = CascadeType.ALL,
	fetch = FetchType.LAZY,
	orphanRemoval = true,
	optional = false
	)
	private Person person;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileNo() {
		return fileNo;
	}

	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
