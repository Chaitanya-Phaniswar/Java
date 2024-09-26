package com.chaitanya.rest.webservices.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	
	@GetMapping(path = "v1/person")
	public Person getVersion1() {
		return new Person("Memoniak rale");
	}
	
	@GetMapping(path="v2/person")
	public Person2 getVersion2() {
		return new Person2(new Name("Dodge","ball"));
	}
	
	@GetMapping(path="person",params="version=1")
	public Person getVersionParamas() {
		return new Person("bAdae");
	}
	
	@GetMapping(path="person",params="version=2")
	public Person2 getVersionParamas2() {
		return new Person2(new Name("Dodge","ball"));
	}
	
	@GetMapping(path="person",headers="X-API-VERSION=1")
	public Person getVersionParamas1() {
		return new Person("bAdae");
	}
	
	@GetMapping(path="person",headers="X-API-VERSION=2")
	public Person2 getVersionParamas3() {
		return new Person2(new Name("Dodge","ball"));
	}
}
