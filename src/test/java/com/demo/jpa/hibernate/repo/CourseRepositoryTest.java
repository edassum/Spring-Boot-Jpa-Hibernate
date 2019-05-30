package com.demo.jpa.hibernate.repo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.jpa.hibernate.SpringBootJpaHibernateApplication;
import com.demo.jpa.hibernate.entities.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootJpaHibernateApplication.class)
public class CourseRepositoryTest {

	private Logger logger =LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository courseRepository;

	@Test
	public void findById_basic() {
		Course course = courseRepository.findById(10001L);
		assertEquals("JPA in 50 Steps", course.getName());
	}
	
	@Test
	@DirtiesContext
	public void deleteById_Basic() {
		courseRepository.deleteById(10001L);
		assertNull(courseRepository.findById(10001L));
	}
	
	@Test
	@DirtiesContext
	public void saveACourse() {
		Course course = courseRepository.findById(10001L);
		course.setName("Blockchain");
		Course savedCourse = courseRepository.save(course);
		assertEquals("Blockchain", savedCourse.getName());
	}
	
	@Test
	@DirtiesContext
	public void playWithEntityManager() {
		courseRepository.playWithEntityManager();
	}
}