package com.training.jpa.hibernate.jpahibernatepractice.repository;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.training.jpa.hibernate.jpahibernatepractice.JpaHibernatePracticeApplication;
import com.training.jpa.hibernate.jpahibernatepractice.entity.Passport;
import com.training.jpa.hibernate.jpahibernatepractice.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=JpaHibernatePracticeApplication.class)
class StudentRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StudentRepository repository;
	
	@Autowired
	EntityManager em;
	
	@Test
	@Transactional
	public void retirieveStudentAndPassportDetails() {
		Student student = em.find(Student.class, 20001L);
		logger.info("studentDetails -> {}",student);
		logger.info("passportDetails -> {}",student.getPassport());
	}
	
	@Test
	@Transactional
	public void retirievePassportAndAssociatedStudent() {
		Passport passport = em.find(Passport.class, 40001L);
		logger.info("passportDetails -> {}",passport);
		logger.info("studentDetails -> {}",passport.getStudent());
	}
	
	@Test
	@Transactional
	public void retrieveStudentAndCourses() {
		Student student = em.find(Student.class,20001L);
		logger.info("students -> {}",student);
		logger.info("courses -> {}",student.getCourses());	
	}
	
}
