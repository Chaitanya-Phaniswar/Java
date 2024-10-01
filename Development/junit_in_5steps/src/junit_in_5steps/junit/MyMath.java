package junit_in_5steps.junit;

public class MyMath {
	public int caluclateSum(int[] arr) {
		int sum=0;
		for(int i: arr) {
			sum+=i;
		}
		return sum;
	}
}
