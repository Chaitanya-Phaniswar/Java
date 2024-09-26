package com.chaitanya.springboot.myfirstspringapp.todo;

import java.time.LocalDate;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

//@Controller
public class TodoController {

	private TodoService todoService;

	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {

		model.addAttribute("todos", todoService.findByUserName(getLoggedInUsername()));
		return "listTodos";
	}

	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteTodo(id);
		return "redirect:list-todos";
	}

	@RequestMapping("add-todo")
	public String addNewTodo(ModelMap model) {
		Todo todo = new Todo(0, getLoggedInUsername(), "", LocalDate.now(), false);
		model.put("todo", todo);
		return "todo";
	}

	@RequestMapping("update-todo")
	public String updateATodo(ModelMap model, @RequestParam int id) {
		Todo todo = todoService.findById(id);
		model.put("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}
		todo.setUsername(getLoggedInUsername());
		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}
		todoService.addTodo(getLoggedInUsername(), todo.getDescription(), todo.getTargetDate());
		return "redirect:list-todos";
	}

	private String getLoggedInUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
