package com.chaitanya.learn_spring_framework.game;

import org.springframework.stereotype.Component;

@Component
public class SuperContraGame implements GamingConsole{
	public void up() {
		System.out.println("Jump");
	}
	public void down() {
		System.out.println("Go in to hole");
	}
	public void left() {
		System.out.println("back");
	}
	public void right() {
		System.out.println("Accelerate");
	}
}
