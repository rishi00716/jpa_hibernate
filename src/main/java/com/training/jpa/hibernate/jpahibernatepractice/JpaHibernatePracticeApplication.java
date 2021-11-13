package com.training.jpa.hibernate.jpahibernatepractice;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.training.jpa.hibernate.jpahibernatepractice.entity.Course;
import com.training.jpa.hibernate.jpahibernatepractice.entity.FullTimeEmployee;
import com.training.jpa.hibernate.jpahibernatepractice.entity.PartTimeEmployee;
import com.training.jpa.hibernate.jpahibernatepractice.repository.CourseRepository;
import com.training.jpa.hibernate.jpahibernatepractice.repository.EmployeeRepository;
import com.training.jpa.hibernate.jpahibernatepractice.repository.StudentRepository;

@SpringBootApplication
public class JpaHibernatePracticeApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;

	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaHibernatePracticeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		Course course = courseRepository.findById(10001L);
//		logger.info("Course 10001 is -> {}",course);
//		
//		courseRepository.deleteById(10001L);
//		
//		courseRepository.save(new Course("Microservices_training"));
		
//		courseRepository.playWithEntityManager();
		
//		studentRepository.saveStudentWithPassport();
		//courseRepository.addHardCodedReviewsForCourse();
		
		//List<Review> reviews = new ArrayList<>();
		//reviews.add(new Review("5","Great Hands On"));
		//reviews.add(new Review("5","HatsOff"));
		//courseRepository.addReviewsForCourse(10003L, reviews);
		
		//studentRepository.insertHardCodedStudentAndCourse();
		//studentRepository.insertStudentAndCourse(new Student("Jack"), new Course("Microservices  in 100 steps"));
		
		/*employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal("50")));
		employeeRepository.insert(new FullTimeEmployee("James", new BigDecimal("10000")));
		logger.info("All Employees -> {}",employeeRepository.retrieveAllEmployees());*/
	}

}
