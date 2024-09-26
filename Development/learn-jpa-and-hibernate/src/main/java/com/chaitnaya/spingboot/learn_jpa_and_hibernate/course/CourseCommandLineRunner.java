package com.chaitnaya.spingboot.learn_jpa_and_hibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.chaitnaya.spingboot.learn_jpa_and_hibernate.course.jdbc.CourseJdbcRepository;
import com.chaitnaya.spingboot.learn_jpa_and_hibernate.course.jpa.CourseJpaRepository;
import com.chaitnaya.spingboot.learn_jpa_and_hibernate.course.springdatajpa.CourseSpringDataRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{

	@Autowired
	private CourseSpringDataRepository courseRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		courseRepository.save(new Course(2,"Learn English","Jhon Doe"));
		courseRepository.save(new Course(1,"Learn Social","Chaitnay"));
		courseRepository.save(new Course(3,"Learn Science","Pavan Sai"));
		
		courseRepository.deleteById(2);
		System.out.print(courseRepository.findById(1));

	}

}
