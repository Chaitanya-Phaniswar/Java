package junit_in_5steps.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExploringAnnotations {
	
	@BeforeEach
	void runningTests() {
		System.out.println("Executing ...");
	}

	@Test
	void test() {
		System.out.println("Testing feature 1");
	}
	
	@Test
	void test2() {
		System.out.println("Testing feature 2");
	}
	
	@Test
	void test3() {
		System.out.println("Testing feature 3");
	}
	
	@AfterAll
	static void testStatus() {
		System.out.println("All test Executed");
	}
}
