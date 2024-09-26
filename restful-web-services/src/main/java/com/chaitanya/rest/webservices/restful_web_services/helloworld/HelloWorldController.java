package com.chaitanya.rest.webservices.restful_web_services.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {
	private MessageSource messageSource;
	public HelloWorldController(MessageSource messageSource) {
		this.messageSource=messageSource;
	}
	@GetMapping(path="greet_me")
	public String helloWorld() {
	
		return "Just Greeting!";
	}
	

	@GetMapping(path="greet_me_bean")
	public HelloWorldBean helloWorldBean() {
	
		return new HelloWorldBean("Just Greeting!");
	}
	
	@GetMapping(path="greet_me_/path_variable/{name}")
	public HelloWorldBean helloWorldBean(@PathVariable String name) {
	
		return new HelloWorldBean("Welcome "+name+"!");
	}
	@GetMapping(path="hello_i18n")
	public String heelo() {
		Locale locale= LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "default",locale);
	}
}
