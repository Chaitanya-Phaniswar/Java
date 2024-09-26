package com.chaitanya.springboot.learn_spring_boot;


import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@RequestMapping("/course")
	public List<Integer> retrieveAlCourses() {
		return Arrays.asList(1,2,3,4);
	}
	
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
	
	@RequestMapping("/buy")
	public String bu() {
		return new String("YOu bothe");
	}

}