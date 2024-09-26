package com.chaitanya.rest.webservices.restful_web_services.user;

import java.net.URI;
import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import jakarta.validation.Valid;

@RestController
public class UserResource {
	private UserDaoService service;

	public UserResource(UserDaoService userDaoService) {
		super();
		this.service = userDaoService;
	}

	@GetMapping(path = "users")
	public List<User> retrieveAllUsers() {
		return service.findAllUsers();
	}

	@GetMapping(path = "users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		User user = service.findOne(id);
		if (user == null)
			throw new UserNotFoundException("id" + id);
		EntityModel<User> entitymodel= EntityModel.of(user);
		WebMvcLinkBuilder link= linkTo(methodOn(this.getClass()).retrieveAllUsers());
		entitymodel.add(link.withRel("all-users"));
		return entitymodel;
	}

	@DeleteMapping(path = "users/{id}")
	public void deleteUser(@PathVariable int id) {
		service.deleteUserById(id);
	}

	@PostMapping(path = "users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		user = service.addUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
