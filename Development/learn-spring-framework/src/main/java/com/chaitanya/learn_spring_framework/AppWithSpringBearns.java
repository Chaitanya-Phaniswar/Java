package com.chaitanya.learn_spring_framework;

import org.springframework.context.annotation.*;

import com.chaitanya.learn_spring_framework.game.GameRunner;
import com.chaitanya.learn_spring_framework.game.GamingConsole;
import com.chaitanya.learn_spring_framework.game.MarioGame;

@Configuration
@ComponentScan("com.chaitanya.learn_spring_framework.game")
public class AppWithSpringBearns {
	
	
	public static void main(String []args) {
		try(
		var context 
		= new AnnotationConfigApplicationContext(AppWithSpringBearns.class))
		{
			context.getBean(GameRunner.class).run();
		}
	}
}	
