package com.demo.jpa.hibernate.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.jpa.hibernate.SpringBootJpaHibernateApplication;
import com.demo.jpa.hibernate.entities.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootJpaHibernateApplication.class)
public class JpqlTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	@Test
	public void jpql_basic() {
		//List resultList = em.createQuery("select c from Course c").getResultList();
		
		 Query query = em.createNamedQuery("query_get_all_courses");
		 List resultList  = query.getResultList();
		logger.info("select c from Course c-> {}", resultList);
	}

	@Test
	public void jpql_typed() {
		TypedQuery<Course> query = em.createQuery("select c from Course c", Course.class);
		List<Course> resultList = query.getResultList();
		// select c from Course c-> [Course [name=Web Service in 100 steps], Course
		// [name=Angular JS in 100 steps updated], Course [name=JPA in 50 Steps], Course
		// [name=Spring in 50 Steps], Course [name=Java in 50 Steps], Course
		// [name=Hibernate in 50 Steps]]
		logger.info("select c from Course c-> {}", resultList);
	}

	@Test
	public void jpql_with_where() {
		List<Course> resultList = em.createQuery("select c from Course c where name like '%50 Steps'", Course.class).getResultList();
		logger.info("select c from Course c where name like '%50 steps'-> {}", resultList);
	}

}