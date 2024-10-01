package junit_in_5steps.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestAssert {

	@Test
	void test() {
		assertArrayEquals(new int [] {1,2,3},new int [] {1,2,3});
		boolean flag=false;
		assertTrue(flag);
		assertNotEquals(-1, 0, "It should not be negative");
	}

}
