package com.chaitanya.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	private static Integer userCount=0;

	static {
		users.add(new User(++userCount, "Chaitanya", LocalDate.now().minusYears(10)));
		users.add(new User(++userCount, "Pavan", LocalDate.now().minusYears(10).minusMonths(5)));
		users.add(new User(++userCount, "Jyothi", LocalDate.now().minusYears(20).minusDays(30)));
	}

	public List<User> findAllUsers() {
		return users;
	}

	public User findOne(int id) {
		java.util.function.Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public User addUser(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}
	public void deleteUserById(int id) {
		java.util.function.Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
	
	}

}
