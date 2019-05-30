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
import org.springframework.transaction.annotation.Transactional;

import com.demo.jpa.hibernate.SpringBootJpaHibernateApplication;
import com.demo.jpa.hibernate.entities.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootJpaHibernateApplication.class)
public class NativeQueryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	@Test
	public void native_queries_basics() {
		Query query = em.createNativeQuery("select * from course", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("select * from course-> {}", resultList);
	}
	
	@Test
	public void native_queries_position() {
		Query query = em.createNativeQuery("select * from course where id=?", Course.class);
		query.setParameter(1, 10001);
		List<Course> resultList = query.getResultList();
		logger.info("select * from course-> {}", resultList);
	}

	@Test
	@Transactional
	public void native_queries_to_update() {
		Query query = em.createNativeQuery("update course set last_updated_date=sysdate()", Course.class);
		int noOfRows = query.executeUpdate();
		logger.info("No Of Rows updated-> {}", noOfRows);
	}

}