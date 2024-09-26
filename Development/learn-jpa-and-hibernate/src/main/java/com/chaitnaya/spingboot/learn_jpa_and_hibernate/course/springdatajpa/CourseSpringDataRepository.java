package com.chaitnaya.spingboot.learn_jpa_and_hibernate.course.springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chaitnaya.spingboot.learn_jpa_and_hibernate.course.Course;

public interface CourseSpringDataRepository extends JpaRepository<Course,Integer>{
	
}
