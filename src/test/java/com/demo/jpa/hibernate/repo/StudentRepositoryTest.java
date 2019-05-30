package com.demo.jpa.hibernate.repo;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.demo.jpa.hibernate.SpringBootJpaHibernateApplication;
import com.demo.jpa.hibernate.entities.Passport;
import com.demo.jpa.hibernate.entities.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootJpaHibernateApplication.class)
public class StudentRepositoryTest {

	private Logger logger =LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	EntityManager em;
	
	@Test
	//@Transactional
	public void someTests() {
		//Db operation -1 retreive
		Student student = em.find(Student.class, 20001L);
		
		//Db operation -2 retreive
		Passport passport = student.getPassport();
		
		//Db operation -3 update
		passport.setPassport_number("E3728213");
		
		//Db operation -4 update
		student.setName("Sumit updated");
	}

	@Test
	@Transactional
	public void retreiveStudentAndPassportDetails() {
		Student student = em.find(Student.class, 20001L);
		logger.info("Student details are ->{}",student);
		logger.info("Passport details are ->{}",student.getPassport());
	}
	
	@Test
	@Transactional
	public void retreivePassportAndAssociatedStudentDetails() {
		Passport passport = em.find(Passport.class, 30001L);
		logger.info("Passport details are ->{}",passport);
		logger.info("Student details are ->{}",passport.getStudent());
	}
}