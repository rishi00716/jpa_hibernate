package com.training.jpa.hibernate.jpahibernatepractice.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.training.jpa.hibernate.jpahibernatepractice.JpaHibernatePracticeApplication;
import com.training.jpa.hibernate.jpahibernatepractice.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=JpaHibernatePracticeApplication.class)
class NativeQueriesTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	@Test
	public void nativeQueries_basic() {
		Query query = em.createNativeQuery("select * from course",Course.class);
		List resultList = query.getResultList();
		logger.info("select * from course -> {}",resultList);
	}
	
	@Test
	public void nativeQueries_with_parameter() {
		Query query = em.createNativeQuery("select * from course where id=?",Course.class);
		query.setParameter(1,10001L);
		List resultList = query.getResultList();
		logger.info("select * from course where id=? -> {}",resultList);
	}
	
	@Test
	public void nativeQueries_with_named_parameter() {
		Query query = em.createNativeQuery("select * from course where id = :id",Course.class);
		query.setParameter("id",10001L);
		List resultList = query.getResultList();
		logger.info("select * from course where id = :id -> {}",resultList);
	}
	
	@Test
	@Transactional
	public void native_queries_to_update() {
		Query query = em.createNativeQuery("Update course set last_updated_date=sysdate()");
		int noOfRowsUpdated = query.executeUpdate();
		logger.info("noOfRowsUpdated  -> {}", noOfRowsUpdated);
	}
}
