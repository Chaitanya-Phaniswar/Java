package com.chaitanya.rest.webservices.restful_web_services.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.chaitanya.rest.webservices.restful_web_services.jpa.PostRepository;
import com.chaitanya.rest.webservices.restful_web_services.jpa.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {
	//private UserDaoService service;
	private UserRepository repository;
	private PostRepository postRepository;

	public UserJpaResource(UserRepository repository,PostRepository postRepository) {
		super();
		this.repository=repository;
		this.postRepository = postRepository;
	}

	@GetMapping(path = "jpa/users")
	public List<User> retrieveAllUsers() {
		return repository.findAll();
	}

	@GetMapping(path = "jpa/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		Optional<User> user = repository.findById(id);
		if (user.isEmpty())
			throw new UserNotFoundException("id" + id);
		EntityModel<User> entitymodel= EntityModel.of(user.get());
		WebMvcLinkBuilder link= linkTo(methodOn(this.getClass()).retrieveAllUsers());
		entitymodel.add(link.withRel("all-users"));
		return entitymodel;
	}

	@DeleteMapping(path = "jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		repository.deleteById(id);
	}
	
	@GetMapping(path ="jpa/users/{id}/posts")
	public List<Post> retrieveUserPosts(@PathVariable int id){
		Optional<User> user = repository.findById(id);
		if (user.isEmpty())
			throw new UserNotFoundException("id" + id);
		return user.get().getPosts();
	}

	@PostMapping(path = "jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		user = repository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping(path ="jpa/users/{id}/posts/{post_id}")
	public EntityModel<Post> retrieveUserPost(@PathVariable int id,@PathVariable int post_id){
		Optional<User> user = repository.findById(id);
		if (user.isEmpty())
			throw new UserNotFoundException("id" + id);
		List<Post> posts=user.get().getPosts();
		java.util.function.Predicate<? super Post> predicate = post -> post.getId()==(post_id);
		Post post= posts.stream().filter(predicate).findFirst().orElse(null);
		EntityModel<Post> entitymodel= EntityModel.of(post);
		WebMvcLinkBuilder link= linkTo(methodOn(this.getClass()).retrieveUserPosts(id));
		entitymodel.add(link.withRel("all-users"));
		return entitymodel;
	}
	
	@PostMapping(path ="jpa/users/{id}/posts")
	public ResponseEntity<Object> createPostForUser(@PathVariable int id,@Valid @RequestBody Post post){
		Optional<User> user = repository.findById(id);
		if (user.isEmpty())
			throw new UserNotFoundException("id" + id);
		post.setUser(user.get());
		Post savedPost = postRepository.save(post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
