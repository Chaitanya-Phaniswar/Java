package com.chaitanya.rest.webservices.restful_web_services.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@JsonFilter("someBeanFilter")
class SomeBean{
	private String feild1;

	private String feild2;
	private String feild3;
	public String getFeild1() {
		return feild1;
	}
	public SomeBean(String feild1, String feild2, String feild3) {
		super();
		this.feild1 = feild1;
		this.feild2 = feild2;
		this.feild3 = feild3;
	}
	public void setFeild1(String feild1) {
		this.feild1 = feild1;
	}
	public String getFeild2() {
		return feild2;
	}
	public void setFeild2(String feild2) {
		this.feild2 = feild2;
	}
	public String getFeild3() {
		return feild3;
	}
	public void setFeild3(String feild3) {
		this.feild3 = feild3;
	}
	
	
}
@RestController
public class FilteringController {
	
	@GetMapping("/somebean")
	public SomeBean getBean() {
		return new SomeBean("r","e","t");
	}
	
	@GetMapping("dynamic")
	public MappingJacksonValue getsBean() {
		MappingJacksonValue mapping= new MappingJacksonValue(new SomeBean("we","thyw","fa"));
		SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("feild1","feild2");
		FilterProvider filters= new SimpleFilterProvider().addFilter("someBeanFilter", filter);
		mapping.setFilters(filters);
		
		return mapping;
	}
}
