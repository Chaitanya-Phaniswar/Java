package com.chaitnaya.spingboot.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chaitnaya.spingboot.learn_jpa_and_hibernate.course.Course;

@Repository
public class CourseJdbcRepository {
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	private static String INSERT_QUERY =
			"""
				INSERT INTO COURSE(id,name,author) Values(?,?,?)
			""";
	private static String DELETE_QUERY =
			"""
				DELETE FROM COURSE WHERE id=1
			""";
	private static String SELECT_QUERY =
			"""
				SELECT * FROM COURSE WHERE id=?
			""";
	
	
	public void insert(Course course) {
		jdbcTemplate.update(INSERT_QUERY,course.getId(),course.getName(),course.getAuthor());
	}
	
	public void deleteById() {
		jdbcTemplate.update(DELETE_QUERY);
	}
	public Course findById(int id) {
		return jdbcTemplate.queryForObject(SELECT_QUERY, 
				new BeanPropertyRowMapper<>(Course.class),id);
	}
}
