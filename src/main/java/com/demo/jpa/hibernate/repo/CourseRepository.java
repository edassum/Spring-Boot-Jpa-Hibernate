package com.demo.jpa.hibernate.repo;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.jpa.hibernate.entities.Course;

@Repository
@Transactional
public class CourseRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	public Course findById(Long id) {
		System.out.println("The id is::" + id);
		return em.find(Course.class, id);
	}

	// Insert or update
	public Course save(Course course) {
		if (course.getId() == null) {
			em.persist(course);
		} else {
			em.merge(course);
		}
		return course;
	}

	public void deleteById(Long id) {
		Course course = findById(id);
		if (course != null) {
			em.remove(course);
		}
	}

	public void playWithEntityManager() {
		logger.info("Inside play with entity manager");
		Course course1 = new Course("Web Service in 100 steps");
		em.persist(course1);
		
		
		Course course2 = findById(10001L);
		course2.setName("JPA in 50 Steps - updated");
		em.persist(course2);
		
		/*
		 * Course course2 = new Course("Angular JS in 100 steps"); em.persist(course1);
		 * em.persist(course2); em.flush();
		 */

		// em.clear();//It clears all entities it manages

		// em.detach(course2);

		/*
		 * course1.setName("Web service in 100 steps updated");
		 * course2.setName("Angular JS in 100 steps updated");
		 * 
		 * em.refresh(course1);
		 * 
		 * em.flush();
		 */
	}
}
