package junit_in_5steps.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit_in_5steps.junit.MyMath;

class MyMathTest {
	private MyMath myMath= new MyMath();

	@Test
	void caluclateSum_ThreeArray() {
		int exprectedValue= 6;
		assertEquals(exprectedValue, myMath.caluclateSum(new int []{1,2,3}));
		
	}
	
	@Test
	void caluclateSum_ZeroArray() {
		int exprectedValue= 0;
		assertEquals(exprectedValue, myMath.caluclateSum(new int[]{}));
		
	}

}
