package com.chaitanya.springboot.myfirstspringapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();
	private static int todosCount = 0;
	static {
		todos.add(new Todo(++todosCount, "Chaitanya", "Learn Spring Boot", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "Chaitanya", "Learn Full Stack", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++todosCount, "Chaitanya", "Learn Data Science", LocalDate.now().plusYears(2), false));
	}

	public List<Todo> findByUserName(String username) {
		Predicate<?super Todo> predicate= todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}

	public void addTodo(String username, String description, LocalDate targetDate) {
		todos.add(new Todo(++todosCount, username, description, targetDate, false));
	}

	public void deleteTodo(int id) {
		Predicate<?super Todo> predicate= todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}
	public Todo findById(int id) {
		Predicate<?super Todo> predicate= todo -> todo.getId() == id;
		return todos.stream().filter(predicate).findFirst().get();
	}
	
	public void updateTodo(Todo todo) {
		deleteTodo(todo.getId());
		todos.add(todo);
	}
}
