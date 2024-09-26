package exercise;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

interface DataService{
	int[] dataDetails();
}
@Component
class MongoDBDataSerivce implements DataService{
	public int [] dataDetails() {
		return new int[]{1,2,3,4,5};
	}
}
@Component
@Primary
class MySQLDBDataService implements DataService{

	@Override
	public int [] dataDetails() {
		// TODO Auto-generated method stub
		return  new int[] {10,20,30,40,50};
	}
}
@Configuration
@ComponentScan("")
public class Exercise {
	public static void main(String []args) {
		try(
				var context = new AnnotationConfigApplicationContext(Exercise.class)){
			Arrays.stream(context.getBean(DataService.class).dataDetails()).forEach(System.out::println);
		}
		
	}
}
