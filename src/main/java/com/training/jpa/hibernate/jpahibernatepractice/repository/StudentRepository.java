package com.training.jpa.hibernate.jpahibernatepractice.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.training.jpa.hibernate.jpahibernatepractice.entity.Course;
import com.training.jpa.hibernate.jpahibernatepractice.entity.Passport;
import com.training.jpa.hibernate.jpahibernatepractice.entity.Student;

@Repository
@Transactional
public class StudentRepository {

	@Autowired
	EntityManager em;
	
	public Student findById(Long id) {
		return em.find(Student.class, id);
	}
	
	public Student save(Student student) {
		if(student.getId()==null) {
			//insert
			em.persist(student);
		}else {
			//update
			em.merge(student);
		}
		return student;
	}
	
	public void deleteById(Long id) {
		Student student = findById(id);
		em.remove(student);
	}
	
	public void saveStudentWithPassport() {
		Passport passport = new Passport("Z1234576");
		em.persist(passport);
		
		Student student = new Student("Mike");
		student.setPassport(passport);
		em.persist(student);
	}
	
	public void insertHardCodedStudentAndCourse() {
		Student student = new Student("Jack");
		Course course = new Course("Microservices  in 100 steps");
		em.persist(student);
		em.persist(course);
		
		student.addCourse(course);
		course.addStudents(student);
		
		em.persist(student);
	}
	
	public void insertStudentAndCourse(Student student,Course course) {
		student.addCourse(course);
		course.addStudents(student);
		em.persist(student);
		em.persist(course);

	}
	
}
