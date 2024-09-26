package com.chaitanya.springboot.myfirstspringapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {
	
	@ResponseBody
	@RequestMapping("say-hello")
	public String sayHello() {
		return "Hello, What are you learning today?";
	}
	
	@ResponseBody
	@RequestMapping("say-hello-html")
	public String sayHelloHtml() {
		return "<h1>Hello, What are you learning today?</h1>";
	}
	
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		return "SayHello";
	}
}
