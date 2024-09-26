package com.chaitnaya.spingboot.learn_jpa_and_hibernate.course.jpa;

import org.springframework.stereotype.Repository;

import com.chaitnaya.spingboot.learn_jpa_and_hibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional 
@Repository
public class CourseJpaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void insert(Course course) {
		entityManager.merge(course);
	}
	
	public Course findById(int id) {
		return entityManager.find(Course.class, id);
	}
	
	public void deleteById(int id) {
		Course couse=entityManager.find(Course.class, id);
		entityManager.remove(couse);
	}
}

