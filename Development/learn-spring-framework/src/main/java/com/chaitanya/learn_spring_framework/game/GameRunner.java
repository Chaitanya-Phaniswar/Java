package com.chaitanya.learn_spring_framework.game;

import org.springframework.stereotype.Component;

@Component
public class GameRunner {
	GamingConsole game;
	public GameRunner(GamingConsole game) {
		this.game = game;
	}
	public void run() {
		System.out.println("Running a Game"+game.toString());
		game.up();
		game.down();
		game.left();
		game.right();
	}
}
