package domain;

import java.util.Date;

import javax.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "POJO_TABLE")
public class Pojo {
	@SequenceGenerator(name = "seq", sequenceName = "POJO_TABLE_ID_SEQ", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME", length = 100, nullable = false)
	private String name;

	@Column(name = "VALUE", precision = 15, scale = 2)
	private BigDecimal value;
	
	@Transient
	private String temporary;
	
	@Lob
	@Column(name = "LARGE_STRİNG")
	private String LargeString;
	
	@Lob
	@Column(name = "LARGE_BYTE")
	private byte[] LargeByteLob;
	
	@Lob
	@Column(name = "LARGE_CHAR")
	private char[] LargeCharLob;
	



	@Column(name = "DATE")
	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name = "TIME")
	@Temporal(TemporalType.TIME)
	private Date time;

	@Column(name = "DATE_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateAndTime;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Date getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getTemporary() {
		return temporary;
	}

	public void setTemporary(String temporary) {
		this.temporary = temporary;
	}

	public String getLargeString() {
		return LargeString;
	}

	public void setLargeString(String largeString) {
		LargeString = largeString;
	}

	public byte[] getLargeByteLob() {
		return LargeByteLob;
	}

	public void setLargeByteLob(byte[] largeByteLob) {
		LargeByteLob = largeByteLob;
	}

	public char[] getLargeCharLob() {
		return LargeCharLob;
	}

	public void setLargeCharLob(char[] largeCharLob) {
		LargeCharLob = largeCharLob;
	}
	
}
