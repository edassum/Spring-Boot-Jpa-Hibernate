package com.demo.jpa.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Passport {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String passport_number;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
	private Student student;

	public Passport() {
	}

	public Passport(String passport_number) {
		super();
		this.passport_number = passport_number;
	}

	public String getPassport_number() {
		return passport_number;
	}

	public void setPassport_number(String passport_number) {
		this.passport_number = passport_number;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Passport [passport_number=" + passport_number + "]";
	}
}
