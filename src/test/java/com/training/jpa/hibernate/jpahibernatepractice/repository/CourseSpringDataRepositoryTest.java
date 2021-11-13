package com.training.jpa.hibernate.jpahibernatepractice.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.training.jpa.hibernate.jpahibernatepractice.JpaHibernatePracticeApplication;
import com.training.jpa.hibernate.jpahibernatepractice.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=JpaHibernatePracticeApplication.class)
class CourseSpringDataRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseSpringDataRepository repository;
	
	@Autowired
	EntityManager em;
	
	@Test
	public void findById_coursePresent() {
		Optional<Course> courseOptional = repository.findById(10001L);
		assertTrue(courseOptional.isPresent());
	}
	
	@Test
	public void findById_courseNotPresent() {
		Optional<Course> courseOptional = repository.findById(20001L);
		assertFalse(courseOptional.isPresent());
	}
	
	@Test
	public void playWithSpringDataRepostiory() {
		logger.info("{}",repository.findAll());
	}
	
	@Test
	public void sort() {
		logger.info("Sorted Courses -> {}",repository.findAll(Sort.by(Sort.Direction.DESC, "name")));
	}
	
	@Test
	public void pagination() {
		PageRequest pageRequest = PageRequest.of(0,3);
		Page<Course> firstPage = repository.findAll(pageRequest);
		logger.info("First page -> {}",firstPage.getContent());
		
		Pageable secondPageable = firstPage.nextPageable();
		Page<Course> secondPage = repository.findAll(secondPageable);
		logger.info("Second page -> {}",secondPage.getContent());
	}
	
	@Test
	public void findUsingName() {
		logger.info("findByName -> {}",repository.findByName("JPA_TRAINING"));
	}
}
