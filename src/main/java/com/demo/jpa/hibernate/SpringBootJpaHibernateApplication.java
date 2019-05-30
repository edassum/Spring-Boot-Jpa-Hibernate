package com.demo.jpa.hibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.jpa.hibernate.entities.Course;
import com.demo.jpa.hibernate.repo.CourseRepository;
import com.demo.jpa.hibernate.repo.StudentRepository;

@SpringBootApplication
public class SpringBootJpaHibernateApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	CourseRepository courseRepository;

	@Autowired
	StudentRepository studentRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Course course = courseRepository.findById(10001L);
		logger.info("Course 10001 -> {}", course);
		/*
		 * courseRepository.deleteById(10003L); courseRepository.save(new
		 * Course("Microservices in 100 steps"));
		 */
		studentRepository.saveStudentWithPassport();
	}
}