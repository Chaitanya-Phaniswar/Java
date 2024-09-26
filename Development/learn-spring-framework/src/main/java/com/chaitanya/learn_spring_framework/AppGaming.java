package com.chaitanya.learn_spring_framework;

import com.chaitanya.learn_spring_framework.game.GameRunner;
import com.chaitanya.learn_spring_framework.game.MarioGame;
import com.chaitanya.learn_spring_framework.game.PacManGame;
import com.chaitanya.learn_spring_framework.game.SuperContraGame;

public class AppGaming {
	
	public static void main(String []args) {
//		SuperContraGame superContraGame = new SuperContraGame();
//		PacManGame pacManGame = new PacManGame();
//		MarioGame marioGame = new MarioGame();
		var game = new MarioGame();
		GameRunner gameRunner= new GameRunner(game);
		gameRunner.run();
	}
}
