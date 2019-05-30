package com.demo.jpa.hibernate.repo;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.jpa.hibernate.entities.Passport;
import com.demo.jpa.hibernate.entities.Student;

@Repository
@Transactional
public class StudentRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	public Student findById(Long id) {
		System.out.println("The id is::" + id);
		return em.find(Student.class, id);
	}

	// Insert or update
	public Student save(Student student) {
		if (student.getId() == null) {
			em.persist(student);
		} else {
			em.merge(student);
		}
		return student;
	}

	public void deleteById(Long id) {
		Student student = findById(id);
		if (student != null) {
			em.remove(student);
		}
	}

	public void saveStudentWithPassport() {
		Passport passport = new Passport("JK987GT");
		em.persist(passport);
		Student student = new Student("Subhradeep");
		student.setPassport(passport);
		em.persist(student);
	}
}
