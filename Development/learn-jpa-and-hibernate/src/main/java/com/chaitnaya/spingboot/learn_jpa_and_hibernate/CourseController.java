package com.chaitnaya.spingboot.learn_jpa_and_hibernate;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chaitnaya.spingboot.learn_jpa_and_hibernate.course.Course;
import com.chaitnaya.spingboot.learn_jpa_and_hibernate.course.jdbc.CourseJdbcRepository;

@RestController
public class CourseController {
		
		@Autowired
		private CourseJdbcRepository courseRepository;
		
		@RequestMapping("/courses")
		public List<Course> retrieveAllCourses() {
			return Arrays.asList(
					new Course(1, "Learn AWS", "in28minutes"),
					new Course(2, "Learn DevOps", "in28minutes"),
					new Course(3, "Learn Azure", "in28minutes"),
					new Course(4, "Learn GCP", "in28minutes")
					//new Course(5, "Learn ME","Mine")
					);
		}
		

		@RequestMapping("/course")
		public Course buy() {
			System.out.print(courseRepository.findById(2));
			return courseRepository.findById(2);
		}
}
