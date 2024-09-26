package com.chaitanya.learn_spring_framework.game;

import org.springframework.stereotype.Component;

@Component
public class PacManGame implements GamingConsole{
	public void up() {
		System.out.println("Upward");
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		System.out.println("Downward");
	}

	@Override
	public void left() {
		// TODO Auto-generated method stub
		System.out.println("Backward");
	}

	@Override
	public void right() {
		// TODO Auto-generated method stub
		System.out.println("Forward");
	}
	
}
