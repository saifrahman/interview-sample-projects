package code.assessment;

public class Factorial {

	public static void main(String[] args) {
		Factorial obj = new Factorial();
		int ans = obj.getFactorial(11);
		System.out.println("Factorial of 11 "  + " is "+ ans);
	}
	
	/**
	 * returns factorial of a given number n
	 * @param n
	 * @return
	 */
	public int getFactorial(int n){
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return (n*getFactorial(n-1));
	}
}
