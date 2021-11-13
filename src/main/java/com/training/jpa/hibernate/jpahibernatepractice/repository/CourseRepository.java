package com.training.jpa.hibernate.jpahibernatepractice.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.training.jpa.hibernate.jpahibernatepractice.entity.Course;
import com.training.jpa.hibernate.jpahibernatepractice.entity.Review;

@Repository
@Transactional
public class CourseRepository {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;
	
	public Course findById(Long id) {
		return em.find(Course.class, id);
	}
	
	public Course save(Course course) {
		if(course.getId()==null) {
			//insert
			em.persist(course);
		}else {
			//update
			em.merge(course);
		}
		return course;
	}
	
	public void deleteById(Long id) {
		Course course = findById(id);
		em.remove(course);
	}
	
	public void playWithEntityManager() {
		Course course1 = new Course("WEBSERVICES_TRAINING");
		em.persist(course1);
		
		Course course2 = new Course("AngularSERVICES_TRAINING");
		em.persist(course2);
		em.flush(); //insert to database
		
		//em.clear(); // this will not update any thing from here onwards
		//em.detach(course2);
		
		course1.setName("UPDATED_WEB_SERVICE");
		course2.setName("UPDATED_Angular_SERVICE"); //this will not be updated due to detach
		
		//em.refresh(course1); // will refresh the updated content
		em.flush();
	}

	
	public void addReviewsForCourse(Long courseId, List<Review> reviews) {
		//get course
		Course course = findById(courseId);
		logger.info("course.getReviews() -> {}",course.getReviews());
		
		for(Review review: reviews) {
			course.addReview(review);
			review.setCourse(course);
			em.persist(review);
		}
		

	}

	//hard coded method: for reference
	public void addHardCodedReviewsForCourse() {
		//get course
		Course course = findById(10003L);
		logger.info("course.getReviews() -> {}",course.getReviews());
		
		Review review1 = new Review("5","Great Hands On");
		Review review2 = new Review("5","HatsOff");
		
		//add review
		course.addReview(review1);
		review1.setCourse(course);
		
		course.addReview(review2);
		review2.setCourse(course);
		
		em.persist(review1);
		em.persist(review2);
	}
	
}
